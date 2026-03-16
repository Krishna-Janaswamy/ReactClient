package com.example.restclientdemo.service;

import com.example.restclientdemo.dto.PostDto;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class JsonPlaceholderService {

    private static final ParameterizedTypeReference<List<PostDto>> POST_LIST_TYPE =
            new ParameterizedTypeReference<>() {
            };

    private final RestClient jsonPlaceholderRestClient;

    public JsonPlaceholderService(RestClient jsonPlaceholderRestClient) {
        this.jsonPlaceholderRestClient = jsonPlaceholderRestClient;
    }

    public List<PostDto> getPosts() {
        return jsonPlaceholderRestClient.get()
                .uri("/posts")
                .retrieve()
                .body(POST_LIST_TYPE);
    }

    public PostDto getPostById(Integer id) {
        return jsonPlaceholderRestClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(PostDto.class);
    }

    public PostDto createPost(PostDto request) {
        return jsonPlaceholderRestClient.post()
                .uri("/posts")
                .body(request)
                .retrieve()
                .body(PostDto.class);
    }
}
