package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(System.out::println);
        Util.sleep(10);
    }
}
