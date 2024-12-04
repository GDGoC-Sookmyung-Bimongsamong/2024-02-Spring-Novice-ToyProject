package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    // 사용자 게시글 조회를 목록으로 보여주기 위해 추가
    List<Posts> findByAuthorIdOrderByCreatedDateDesc(Long authorId);
}
