package com.jojoldu.book.springboot.service.mypage;

import com.jojoldu.book.springboot.domain.mypage.dto.MyPagePostsDto;
import com.jojoldu.book.springboot.domain.mypage.dto.MyPageResponseDto;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.domain.user.User;
import com.jojoldu.book.springboot.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyPageService {
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public MyPageResponseDto getMyPage(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 없습니다."));

        System.out.println("User ID: " + user.getId());

        List<Posts> posts = postsRepository.findByUserIdOrderByCreatedDateDesc(user.getId());

        System.out.println("Found posts: " + posts.size());

        List<MyPagePostsDto> postsDto = posts.stream()
                .map(MyPagePostsDto::new)
                .collect(Collectors.toList());

        return new MyPageResponseDto(user.getName(), user.getRegistrationId(), postsDto);
    }
}