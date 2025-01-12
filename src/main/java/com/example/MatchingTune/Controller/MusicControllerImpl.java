package com.example.MatchingTune.Controller;

import com.example.MatchingTune.Service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/music")
class musiccontroller {

    private final MusicService musicService;

    @Autowired
    public musiccontroller(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/recommendations")
    public Mono<ResponseEntity<String>> getMusicBuddyRecommendations(@RequestParam String preferences) {
        return musicService.getMusicBuddyRecommendations(preferences)
                .map(recommendations -> ResponseEntity.ok(recommendations))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/similar")
    public Mono<ResponseEntity<String>> getTasteDiveSimilar(@RequestParam String query) {
        return musicService.getTasteDiveSimilar(query)
                .map(similarMusic -> ResponseEntity.ok(similarMusic))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
