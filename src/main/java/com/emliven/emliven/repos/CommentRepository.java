package com.emliven.emliven.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emliven.emliven.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByUserIdAndEventId(Long userId, Long eventId);

	List<Comment> findByUserId(Long userId);

	List<Comment> findByEventId(Long eventId);

}
