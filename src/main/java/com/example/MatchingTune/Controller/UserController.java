package com.example.MatchingTune.Controller;

import com.example.MatchingTune.Service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/music")
class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/recommendations")
    public Mono<ResponseEntity<String>> getMusicBuddyRecommendations(@RequestParam String preferences) {
        return musicService.getMusicBuddyRecommendations(preferences)
                .map(result -> ResponseEntity.ok(result))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/similar")
    public Mono<ResponseEntity<String>> getTasteDiveSimilar(@RequestParam String query) {
        return musicService.getTasteDiveSimilar(query)
                .map(result -> ResponseEntity.ok(result))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/geolocated")
    public Mono<ResponseEntity<String>> getGeolocatedInfo(@RequestParam String location) {
        return musicService.getGeolocatedInfo(location)
                .map(result -> ResponseEntity.ok(result))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/youtube")
    public Mono<ResponseEntity<String>> getYoutubeMusicInfo(@RequestParam String query) {
        return musicService.getYoutubeMusicInfo(query)
                .map(result -> ResponseEntity.ok(result))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/soundcloud")
    public Mono<ResponseEntity<String>> getSoundCloudMusic(@RequestParam String query) {
        return musicService.getSoundCloudMusic(query)
                .map(result -> ResponseEntity.ok(result))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
