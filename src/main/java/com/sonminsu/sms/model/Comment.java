package com.sonminsu.sms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(length = 1000)
    private String comment;

    private LocalDateTime createDate;

    @ManyToOne
    private Post post;
}
