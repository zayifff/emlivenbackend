package com.emliven.emliven.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emliven.emliven.entities.Comment;
import com.emliven.emliven.requests.CommentCreateRequest;
import com.emliven.emliven.requests.CommentUpdateRequest;
import com.emliven.emliven.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	private CommentService commentService;
	
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> eventId){
		return commentService.getAllCommentsWithParam(userId, eventId);
	}
	
	@GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return commentService.getOneCommentById(commentId);
    }
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest request) {
		return commentService.createOneComment(request);
		
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
		return commentService.updateOneCommentById(commentId,request);
		
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneComment(@PathVariable Long commentId) {
		commentService.deleteOneCommentById(commentId);
	}
	

}
