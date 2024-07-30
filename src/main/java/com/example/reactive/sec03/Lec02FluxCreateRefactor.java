package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import com.example.reactive.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {
    public static void main(String[] args) {
        var nameProducer=new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber("Subscriber 1"));
        Runnable runnable=nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            Util.sleep(1);
            runnable.run();

        }
        Util.sleep(1);
    }
}
