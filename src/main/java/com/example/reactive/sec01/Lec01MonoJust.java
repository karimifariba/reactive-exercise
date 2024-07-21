package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;

public class Lec01MonoJust {
    public static void main(String[] args) {
        var mono= Mono.just("Hello Reactive");

        System.out.println(mono);
        mono.subscribe(System.out::println);
    }
}
