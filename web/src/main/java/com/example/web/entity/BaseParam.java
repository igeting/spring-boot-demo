package com.example.web.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BaseParam extends Basic {
    private String id;
    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
}
