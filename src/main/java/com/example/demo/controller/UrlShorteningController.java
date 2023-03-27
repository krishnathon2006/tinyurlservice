package com.example.demo.controller;

import com.example.demo.service.UrlShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShorteningController {
    @Autowired
    private UrlShorteningService urlShorteningService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestParam("longUrl") String longUrl) {
        String shortUrl = urlShorteningService.shortenUrl(longUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/expand/{shortUrl}")
    public ResponseEntity<String> expandUrl(@PathVariable String shortUrl) {
        String longUrl = urlShorteningService.getLongUrl(shortUrl);
        if (longUrl != null) {
            return ResponseEntity.ok(longUrl);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

