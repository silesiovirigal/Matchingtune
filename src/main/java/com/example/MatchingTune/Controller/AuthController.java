package com.example.MatchingTune.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Base64;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AuthController {


    private final WebClient webClient;


    private final String clientId = "9f62057b9ab34fffbad49625cd5d4c9a";
    private final String clientSecret = "aed60a722dae45208f93f3d6851478fc";
    private final String redirectUri = "http://localhost:8080/callback";


    private String accessToken;
    private String refreshToken;
    private long tokenExpiryTime;


    public AuthController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://accounts.spotify.com").build();
    }


    @GetMapping("/")
    public String home() {
        return "Servidor Spring Boot funcionando!";
    }


    @GetMapping("/callback")
    public Mono<String> callback(@RequestParam(name = "code", required = false) String code) {
        if (code == null) {
            return Mono.just("Nenhum código foi recebido.");
        }


        String authHeader = "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());


        String body = "grant_type=authorization_code&code=" + code + "&redirect_uri=" + redirectUri;


        return webClient.post()
                .uri("/api/token")
                .header(HttpHeaders.AUTHORIZATION, authHeader)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(response -> {
                    try {

                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode jsonResponse = objectMapper.readTree(response);


                        accessToken = jsonResponse.get("access_token").asText();
                        refreshToken = jsonResponse.get("refresh_token").asText();
                        int expiresIn = jsonResponse.get("expires_in").asInt();
                        tokenExpiryTime = System.currentTimeMillis() + (expiresIn * 1000);

                        return Mono.just("Token de acesso recebido com sucesso!");
                    } catch (Exception e) {
                        return Mono.just("Erro ao analisar a resposta JSON: " + e.getMessage());
                    }
                });
    }


    private void refreshAccessToken() {
        String authHeader = "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
        String body = "grant_type=refresh_token&refresh_token=" + refreshToken;

        String response = webClient.post()
                .uri("/api/token")
                .header(HttpHeaders.AUTHORIZATION, authHeader)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response);

            accessToken = jsonResponse.get("access_token").asText();
            int expiresIn = jsonResponse.get("expires_in").asInt();
            tokenExpiryTime = System.currentTimeMillis() + (expiresIn * 1000);
        } catch (Exception e) {
            e.printStackTrace(); // Log de erro
        }
    }


    private String getValidAccessToken() {
        long currentTime = System.currentTimeMillis();
        if (accessToken == null || currentTime >= tokenExpiryTime) {
            refreshAccessToken();
        }
        return accessToken;
    }


    @GetMapping("/user-playlists")
    public Mono<String> getUserPlaylists() {
        String validAccessToken = getValidAccessToken();

        return webClient.mutate()
                .baseUrl("https://api.spotify.com/v1")
                .build()
                .get()
                .uri("/me/playlists")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + validAccessToken)
                .retrieve()
                .bodyToMono(String.class);
    }
}