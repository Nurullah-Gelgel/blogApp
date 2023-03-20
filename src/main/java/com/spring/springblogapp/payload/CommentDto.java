package com.spring.springblogapp.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CommentDto {

    private long id;
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @NotEmpty(message = "Email should not be null or empty")
    private String email;

    @NotEmpty(message = "Body should not be null or empty")
    @Size(min = 10 , message = "should have 10 characters")
    private String body;
}
