package com.sonminsu.sms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;


    @Column(length = 10)
    private String userName; //닉네임

    @Column(length = 10)
    private String userId; //아이디

    @Column(length = 10)
    private String userPassword; //비밀번호

    @Column(unique = true)
    private String email;

}
