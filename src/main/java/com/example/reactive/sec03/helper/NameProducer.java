package com.example.reactive.sec03.helper;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> sink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.sink = stringFluxSink;

    }
    public void produce() {
        var fakeName= Util.faker().name().fullName();
        var thread=Thread.currentThread().getName();
        this.sink.next(fakeName+" : "+thread);
    }
}
