package com.example.MatchingTune.Controller;

import com.example.MatchingTune.Service.YoutubeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
class YouTubeController {

    private final YoutubeService youTubeService;

    public YouTubeController(YoutubeService youTubeService) {
        this.youTubeService = youTubeService;
    }

    @GetMapping("/youtube/search")
    public Mono<String> searchVideos(@RequestParam String query) {
        return youTubeService.searchVideos(query);
    }
}
