package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;

public class Lec07MonoFromRunnable {
    public static void main(String[] args) {
        /*var runnable = runnable();
        Mono.fromRunnable(runnable)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());*/
        Mono.fromRunnable(() -> System.out.println("fromRunnable"))
//                .subscribe();
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        Mono.fromSupplier(() -> "fromSupplier")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        Mono.fromCallable(() -> "fromCallable")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    private static Runnable runnable() {
        Util.sleep(5);
        throw new RuntimeException("Exception....");
//        return ()-> System.out.println("runnable called");

    }
}
