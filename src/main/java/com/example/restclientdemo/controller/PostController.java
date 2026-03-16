package com.example.restclientdemo.controller;

import com.example.restclientdemo.dto.PostDto;
import com.example.restclientdemo.service.JsonPlaceholderService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final JsonPlaceholderService jsonPlaceholderService;

    public PostController(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return jsonPlaceholderService.getPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Integer id) {
        return jsonPlaceholderService.getPostById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto createPost(@RequestBody PostDto request) {
        return jsonPlaceholderService.createPost(request);
    }
}
