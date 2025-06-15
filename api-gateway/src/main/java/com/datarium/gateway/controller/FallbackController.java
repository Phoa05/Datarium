package com.datarium.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/assets")
    public Mono<String> assetsFallback() {
        return Mono.just("Serviço de ativos temporariamente indisponível. Tente novamente mais tarde.");
    }
}