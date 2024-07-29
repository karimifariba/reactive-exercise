package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        var mono= Mono.just("a");
        var flux= Flux.from(mono);
        flux.subscribe(Util.onNext());
    }
}
