package com.example.MatchingTune.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class GeolocationService {

    private static final Logger log = LoggerFactory.getLogger(GeolocationService.class);


    private final WebClient webClient;

    // A chave de API e o prefixo serão carregados de application.properties ou application.yml
    @Value("${geolocated.api.key}")
    private String apiKey;

    @Value("${geolocated.api.endpoint}")
    private String apiEndpoint;

    public GeolocationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build(); // Base URL será configurada dinamicamente
    }


    public Mono<String> getGeolocation(String ip) {
        log.info("Iniciando requisição de geolocalização para IP: {}", ip);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host(apiEndpoint)
                        .path("/api/geolocation")
                        .queryParam("apiKey", apiKey)
                        .queryParam("ip", ip)
                        .build())
                .header(HttpHeaders.ACCEPT, "application/json")
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> log.info("Resposta da API de geolocalização: {}", response))
                .doOnError(error -> log.error("Erro ao chamar a API de geolocalização", error));
    }
}