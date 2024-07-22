package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec04MonoFromSupplier {
    public static void main(String[] args) {
        Supplier<String> supplier = Lec04MonoFromSupplier::getName;
        var mono = Mono.fromSupplier(supplier);
        mono
                .doOnNext(s -> System.out.println("mono from supplier"))
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
        Callable<String> callable = Lec04MonoFromSupplier::getName;
        var mono2 = Mono.fromCallable(callable);
        mono2
                .doOnNext(s -> System.out.println("mono2 from callable"))
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static String getName() {
        return Util.faker().name().fullName();
    }
}
