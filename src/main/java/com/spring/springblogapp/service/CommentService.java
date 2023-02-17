package com.spring.springblogapp.service;

import com.spring.springblogapp.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId ,CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentsById(long postId, long commentId);

    CommentDto updateComments(long postId, long commentId, CommentDto commentRequest);

    void deleteComment(long postId, long commentId);
}
