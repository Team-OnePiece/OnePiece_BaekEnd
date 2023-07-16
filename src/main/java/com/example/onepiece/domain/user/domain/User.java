package com.example.onepiece.domain.user.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String accountId;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 9)
    private String nickname;

    private String profileImage;

    @Column(nullable = false, length = 3)
    private Integer grade;

    @Column(nullable = false, length = 4)
    private Integer classNumber;

    @Column(nullable = false, length = 16)
    private Integer number;

    @Builder
    public User(String accountId, String password, String nickname, String profileImage, Integer grade, Integer classNumber, Integer number) {
        this.accountId = accountId;
        this.password = password;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.grade = grade;
        this.classNumber = classNumber;
        this.number = number;
    }

    public void update(String nickname, String profileImage){
        this.nickname = nickname;
        this.profileImage = profileImage;
    }
}
