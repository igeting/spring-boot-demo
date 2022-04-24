package com.example.web.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BaseParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
}
