package com.example.base.util.other;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class BeanUtil {
    private static Mapper mapper = new DozerBeanMapper();

    public static <D, E> E trans(D d, Class<E> clazz) {
        if (d == null) {
            return null;
        }
        return mapper.map(d, clazz);
    }

    public static <D, E> List<E> transArray(D[] ds, Class<E> clazz) {
        List<E> es = new ArrayList<>();
        for (D d : ds) {
            E e = trans(d, clazz);
            if (e != null) {
                es.add(e);
            }
        }
        return es;
    }

    public static <D, E> List<E> transList(List<D> ds, Class<E> clazz) {
        List<E> es = new ArrayList<>();
        for (D d : ds) {
            E e = trans(d, clazz);
            if (e != null) {
                es.add(e);
            }
        }
        return es;
    }
}
