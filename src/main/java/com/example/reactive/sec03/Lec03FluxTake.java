package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        var flux = Flux.range(1, 15)
                .log();
        flux.take(10)
                .log()
                .subscribe(Util.subscriber());
        flux.take(3)
                .subscribe(Util.subscriber());
    }
}
