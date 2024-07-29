package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec10FluxToMono {
    public static void main(String[] args) {
        Flux.range(1,10)
        .filter(i -> i%2==0)
                .next()
                .subscribe(Util.onNext());
    }
}
