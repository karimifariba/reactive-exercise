package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do {
                Util.sleep(1);
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("Sweden"));
            fluxSink.complete();
        }).subscribe(Util.subscriber(Util.faker().name().fullName()));
    }
}
