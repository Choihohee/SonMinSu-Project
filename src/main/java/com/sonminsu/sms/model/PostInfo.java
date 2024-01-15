package com.sonminsu.sms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PostInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postInfoId;

    @Column(length = 30)
    private String BrandName;   //브랜드명

    @Column(length = 30)
    private String prodectName; //제품명

    @Column(length = 200)
    private String urlLink; //제품링크

    @ManyToOne
    private Post post;
}
