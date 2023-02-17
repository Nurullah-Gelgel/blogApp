package com.spring.springblogapp.controller;

import com.spring.springblogapp.payload.CommentDto;
import com.spring.springblogapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId, @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId){
        return commentService.getCommentsByPostId(postId) ;
    }
    @GetMapping("/posts/{postId}/comments/{Id}")
    public ResponseEntity<CommentDto> getCommentsById(@PathVariable(value = "postId") long postId,
                                                      @PathVariable(value = "Id") long commentId){
        CommentDto commentDto = commentService.getCommentsById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updatePost(@PathVariable(value = "postId") long postId,
                                                 @PathVariable("id") long commentId,
                                                 @RequestBody CommentDto commentDto){
        CommentDto updatedComment = commentService.updateComments(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") long postId,@PathVariable(value = "id") long commentId){
        commentService.deleteComment(postId, commentId);

        return new ResponseEntity<>("Comment deleted",HttpStatus.OK);
    }

}
