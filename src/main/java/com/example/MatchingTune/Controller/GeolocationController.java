package com.example.MatchingTune.Controller;

import com.example.MatchingTune.Service.GeolocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GeolocationController {

    private final GeolocationService geolocationService;

    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    // Endpoint para consultar informações de geolocalização
    @GetMapping("/geolocation")
    public Mono<String> getGeolocation(@RequestParam String ip) {
        return geolocationService.getGeolocation(ip);
    }
}