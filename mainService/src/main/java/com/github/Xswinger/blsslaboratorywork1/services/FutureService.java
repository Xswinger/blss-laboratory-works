package com.github.Xswinger.blsslaboratorywork1.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class FutureService {

    private final ConcurrentMap<Long, CompletableFuture<Long>> responseFutures = new ConcurrentHashMap<>();

    public CompletableFuture<Long> addResponseFuture(Long messageId) {
        CompletableFuture<Long> future = new CompletableFuture<>();
        responseFutures.put(messageId, future);
        return future;
    }

}
