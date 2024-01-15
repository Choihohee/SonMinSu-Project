package com.sonminsu.sms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(length = 30)
    private String subject; //제목

    private LocalDateTime createDate;   //만든 날짜

    @Column(length = 255)
    private String imagePath;      //이미지
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Recommend> RecommendList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> CommentList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE) //CascadeType.REMOVE는 질문을 삭제하면 그에 달린 정보들도 모두 삭제되도록 함
    private List<PostInfo> PostInfoList;
}
