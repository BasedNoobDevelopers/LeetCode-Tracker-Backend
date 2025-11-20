package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ImageService {

    private final WebClient webClient;
    private final String imageServiceURL = "http://127.0.0.1:5000";

    public ImageService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(imageServiceURL).build();
    }

    public void getImageURL() {
        webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(System.out::println)
                .block();
    }

    public void uploadImage(MultipartFile file) {
        // Build multipart body
        getImageURL();
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder
                .part("file", file.getResource())
                .filename(file.getOriginalFilename())
                .contentType(MediaType.parseMediaType(file.getContentType()));

        String response = webClient.post()
                .uri("/upload")
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(System.out::println)
                .block();

        System.out.println("Not here");
        System.out.println("Flask response: " + response);
    }
}
