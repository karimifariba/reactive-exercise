package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;

public class Lec02Subscribe {
    public static void main(String[] args) {
        var mono = Mono.just("Hello Reactive");
        var monoInt=Mono.just(10);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
        monoInt
                .map(i->i/0)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

    }
}
