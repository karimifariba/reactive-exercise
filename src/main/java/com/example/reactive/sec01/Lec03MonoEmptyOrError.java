package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoEmptyOrError {

    public static void main(String[] args) {
        getUser(3)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }

    private static Mono<String> getUser(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().fullName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException(" userId is wrong"));
        }
    }
}
