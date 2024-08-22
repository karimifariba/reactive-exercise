package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import com.example.reactive.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        NameProducer producer = new NameProducer();
        var f=Flux.push(producer);
        f.subscribe(Util.subscriber());
        Runnable runnable = producer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Util.sleep(15);
    }
}
