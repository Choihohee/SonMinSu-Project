package com.sonminsu.sms.question;

import com.sonminsu.sms.answer.Answer;
import com.sonminsu.sms.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	private String subject;

	@Column(length = 30)
	private String brandName;   //브랜드명

	@Column(length = 30)
	private String productName; //제품명

	@Column(length = 200)
	private String urlLink; //제품링크

	private LocalDateTime createDate;

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;

	@ManyToOne
	private SiteUser author;

	private LocalDateTime modifyDate;

	@ManyToMany
	@JoinTable(
			name = "question_voters",
			joinColumns = @JoinColumn(name = "question_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<SiteUser> voter;

	public Question() {
		this.voter = new HashSet<>();
	}
}
