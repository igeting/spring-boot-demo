package com.example.web.model.base;

import com.baomidou.mybatisplus.annotation.*;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @SerializedName(value = "id")
    private Long id;

    @TableField(value = "created_at", fill = FieldFill.INSERT)
    @SerializedName(value = "created_at")
    private Date createdAt;

    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    @SerializedName(value = "updated_at")
    private Date updatedAt;

    @SerializedName(value = "created_by")
    private String createdBy;

    @SerializedName(value = "updated_by")
    private String updatedBy;

    /*
    @Version
    @SerializedName(value = "version")
    private Long version;
    */
}
