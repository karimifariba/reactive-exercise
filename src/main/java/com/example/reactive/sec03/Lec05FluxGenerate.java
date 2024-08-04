package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("SynchronousSink: ");
                    synchronousSink.next(Util.faker().name().fullName());
                    synchronousSink.complete();
                })
                .take(15)
                .subscribe(Util.onNext());
    }
}
