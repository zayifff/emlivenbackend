package com.emliven.emliven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emliven.emliven.entities.Comment;
import com.emliven.emliven.entities.Events;
import com.emliven.emliven.entities.User;
import com.emliven.emliven.repos.CommentRepository;
import com.emliven.emliven.requests.CommentCreateRequest;
import com.emliven.emliven.requests.CommentUpdateRequest;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private EventsService eventsService;

    public CommentService(CommentRepository commentRepository, UserService userService, EventsService eventsService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.eventsService = eventsService;
    }

    @GetMapping
    public List<Comment> getAllCommentsWithParam(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> eventId) {
        if (userId.isPresent() && eventId.isPresent()) {
            return commentRepository.findByUserIdAndEventId(userId.get(), eventId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (eventId.isPresent()) {
            return commentRepository.findByEventId(eventId.get());
        } else {
            return commentRepository.findAll();
        }
    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest request) {
        User user = userService.getOneUser(request.getUserId());
        Events event = eventsService.getOneEventById(request.getEventsId());
        if (user != null && event != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(request.getId());
            commentToSave.setEvent(event);
            commentToSave.setUser(user);
            commentToSave.setText(request.getText());
            return commentRepository.save(commentToSave);
        } else
            return null;
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(request.getText());
            return commentRepository.save(commentToUpdate);
        } else {
            return null;
        }
    }

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}
}
