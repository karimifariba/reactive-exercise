package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
//        Flux.range(2,9).subscribe(Util.onNext(), Util.onError());
        Flux.range(2, 9)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
