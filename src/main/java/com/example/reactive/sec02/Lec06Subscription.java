package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(3,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println( "onSubscribe"+subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer i) {
                        System.out.println("onNext"+i);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
        Util.sleep(3);
        atomicReference.get().request(5);
        Util.sleep(4);
        atomicReference.get().request(6);
        Util.sleep(2);
        atomicReference.get().cancel();
        Util.sleep(1);
        atomicReference.get().request(2);
    }
}
