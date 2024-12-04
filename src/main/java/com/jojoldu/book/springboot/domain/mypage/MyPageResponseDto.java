package com.jojoldu.book.springboot.domain.mypage;

import com.jojoldu.book.springboot.domain.mypage.dto.MyPagePostsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
public class MyPageResponseDto {
    private String name;
    private String registrationId;
    private List<MyPagePostsDto> posts;

    public MyPageResponseDto(String name, String registrationId, List<MyPagePostsDto> posts) {
        this.name = name;
        this.registrationId = registrationId;
        this.posts = posts;
    }
}