package com.example.reactive.sec02.assignment;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class StockPricePublisher {
    public static Flux<Integer> getStockPrice() {

        var atomicInt = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInt.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        Integer::sum

                ));

    }
}
