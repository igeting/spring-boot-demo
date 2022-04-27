package com.example.web.dto;

public interface Converter<D, E> {
    /**
     * dto convert to entity
     * @param s
     * @return
     */
    E convertEnt(D s);

    /**
     * entity convert to dto
     * @param s
     * @return
     */
    D convertDto(E s);
}
