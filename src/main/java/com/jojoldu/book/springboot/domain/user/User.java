package com.jojoldu.book.springboot.domain.user;


import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    // 로그인 경로
    @Column
    private String registrationId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // 생성자에 로그인 경로 추가
    @Builder
    public User(String name, String email, String picture, Role role, String registrationId){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.registrationId = registrationId;
    }

    public User update(String name, String picure){
        this.name = name;
        this.picture = picure;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
