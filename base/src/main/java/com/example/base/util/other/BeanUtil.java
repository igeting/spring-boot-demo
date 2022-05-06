package com.example.base.util.other;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class BeanUtil {
    private static Mapper mapper = new DozerBeanMapper();

    public static <D, E> E convertBean(D t, Class<E> clazz) {
        if (t == null) {
            return null;
        }
        return mapper.map(t, clazz);
    }

    public static <D, E> List<E> convertArray(D[] ts, Class<E> clazz) {
        List<E> es = new ArrayList<>();
        if (ts == null) {
            return es;
        }
        for (D d : ts) {
            E e = (E) convertBean(d, clazz);
            if (e != null)
                es.add(e);
        }
        return es;
    }

    public static <D, E> List<E> convertList(List<D> ts, Class<E> clazz) {
        List<E> es = new ArrayList<>();
        if (ts == null) {
            return es;
        }
        for (D d : ts) {
            E e = (E) convertBean(d, clazz);
            if (e != null)
                es.add(e);
        }
        return es;
    }
}
