package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec06MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName(1))
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
        Util.sleep(1);
    }

    private static CompletableFuture<String> getName(int callNumber ) {
        System.out.println("callNumber is : "+callNumber);
        return CompletableFuture.supplyAsync(()-> Util.faker().name().fullName());
    }
}
