package com.example.MatchingTune.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class MusicService {

    private final WebClient webClient;

    public MusicService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
    }

    public Mono<String> getMusicBuddyRecommendations(String preferences) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/recommendations")
                        .queryParam("preferences", preferences)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        e -> Mono.just("Erro na API MusicBuddy: " + e.getMessage()));
    }

    public Mono<String> getTasteDiveSimilar(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/similar")
                        .queryParam("q", query)
                        .queryParam("type", "music")
                        .queryParam("k", "your_tastedive_api_key")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        e -> Mono.just("Erro na API TasteDive: " + e.getMessage()));
    }

    public Mono<String> getGeolocatedInfo(String location) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/geolocated")
                        .queryParam("location", location)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        e -> Mono.just("Erro na API Geolocated: " + e.getMessage()));
    }

    public Mono<String> getYoutubeMusicInfo(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/youtube")
                        .queryParam("query", query)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        e -> Mono.just("Erro na API YouTube: " + e.getMessage()));
    }

    public Mono<String> getSoundCloudMusic(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/soundcloud")
                        .queryParam("query", query)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        e -> Mono.just("Erro na API SoundCloud: " + e.getMessage()));
    }
}
