package com.example.base.util.other;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class QRUtils {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    private static final List<String> IMAGE_TYPE = new ArrayList<>();

    static {
        IMAGE_TYPE.add("png");
        IMAGE_TYPE.add("jpg");
    }

    public static BufferedImage generateImage(String content, int size, String logoPath) {
        if (size <= 0) {
            size = 250;
        }

        BufferedImage image = null;
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            //设置编码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            //设置容错率最高
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.MARGIN, 1);
            //生成二维码
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hints);
            //获取二维码尺寸
            int codeWidth = bitMatrix.getWidth();
            int codeHeight = bitMatrix.getHeight();
            image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    image.setRGB(i, j, bitMatrix.get(i, j) ? BLACK : WHITE);
                }
            }

            if (logoPath != null && !"".equals(logoPath)) {
                File logPic = new File(logoPath);
                if (logPic.exists()) {
                    Graphics2D g = image.createGraphics();
                    BufferedImage logo = ImageIO.read(logPic);
                    int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ? (image.getWidth() * 2 / 10) : logo.getWidth(null);
                    int heightLogo = logo.getHeight(null) > image.getHeight() * 2 / 10 ? (image.getHeight() * 2 / 10) : logo.getHeight(null);
                    int x = (image.getWidth() - widthLogo) / 2;
                    int y = (image.getHeight() - heightLogo) / 2;
                    g.drawImage(logo, x, y, widthLogo, heightLogo, null);
                    g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
                    g.setStroke(new BasicStroke(2));
                    g.setColor(Color.WHITE);
                    g.drawRect(x, y, widthLogo, heightLogo);
                    g.dispose();
                    logo.flush();
                    image.flush();
                }
            }
        } catch (Exception e) {
            log.error("QRUtils.getBufferedImage error:{}", e);
        }
        return image;
    }

    public static byte[] createQR(String content, int size, String logoPath) {
        byte[] img = null;
        try {
            String imageType = "png";
            BufferedImage image = generateImage(content, size, logoPath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(image, imageType, bos);
            img = bos.toByteArray();
        } catch (Exception e) {
            log.error("QRUtils.createQR error:{}", e);
        }
        return img;
    }

    public static void main(String[] args) {
        byte[] img = createQR("hello world", 200, null);
        try {
            FileCopyUtils.copy(img, new File("test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
