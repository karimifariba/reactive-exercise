package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {

    public static void main(String[] args) {
        Flux.generate(() -> 1, (state, sink) ->
                {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if (state >= 100 || country.equalsIgnoreCase("Germany")) {
                        sink.complete();
                    }
                    state++;
                    return state;
                })
                .take(100)
                .subscribe(Util.subscriber());
    }
}
