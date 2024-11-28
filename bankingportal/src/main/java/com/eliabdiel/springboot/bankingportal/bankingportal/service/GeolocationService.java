package com.eliabdiel.springboot.bankingportal.bankingportal.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.eliabdiel.springboot.bankingportal.bankingportal.dto.GeolocationResponse;

public interface GeolocationService {

    @Async
    public CompletableFuture<GeolocationResponse> getGeolocation(String ip);
}
