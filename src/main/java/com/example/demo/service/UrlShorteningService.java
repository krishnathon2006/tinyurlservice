package com.example.demo.service;

import com.example.demo.model.UrlMapping;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlShorteningService {
    private final Map<String, UrlMapping> urlMappings = new HashMap<>();

    public String shortenUrl(String longUrl) {
        String shortUrl = generateShortUrl(longUrl);
        urlMappings.put(shortUrl, new UrlMapping(longUrl, shortUrl));
        return shortUrl;
    }

    public String getLongUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappings.get(shortUrl);
        if (urlMapping != null) {
            return urlMapping.getLongUrl();
        }
        return null;
    }

    private String generateShortUrl(String longUrl) {
        // A simple way to generate a short URL, consider using a more sophisticated algorithm
        return Integer.toHexString(longUrl.hashCode());
    }
}

