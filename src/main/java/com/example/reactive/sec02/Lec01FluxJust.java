package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {
    public static void main(String[] args) {
        var flux = Flux.just(1, 2, 3, 4, 5);
//        flux.subscribe(System.out::println);
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        var flux2 = Flux.just(1, 2, 3, 4,Util.faker().name().fullName(), 5);
        flux2.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        var flux3 = Flux.just("this is flux example");
        flux3
                .map(String::length)
//                .map(l->l/0)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
