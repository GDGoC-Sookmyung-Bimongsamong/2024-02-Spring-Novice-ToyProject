package com.jojoldu.book.springboot.domain.mypage.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class MyPagePostsDto {
    private Long id;
    private String title;
    private LocalDateTime createdDate;

    public MyPagePostsDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.createdDate = entity.getCreatedDate();
    }
}