package com.example.jpa.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends BaseModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "user_info_s", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "user_info_s", name = "user_info_s", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;
}










