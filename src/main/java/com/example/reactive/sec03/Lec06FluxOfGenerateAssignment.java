package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxOfGenerateAssignment {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        Flux.generate(synchronousSink -> {
                    System.out.println("generating country name");
                    System.out.println("counter:"+counter.get());
                    var country = Util.faker().country().name();
                    System.out.println("country name: " + country);
                    synchronousSink.next(country);
//                    Util.sleep(1);
                    counter.incrementAndGet();
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                    if (counter.get() % 5==0) {
                        Util.sleep(1);
                    }
                })
                .subscribe(Util.onNext());
    }
}
