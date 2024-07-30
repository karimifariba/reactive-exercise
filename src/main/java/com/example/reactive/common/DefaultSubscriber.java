package com.example.reactive.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {
    private String name="";

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    public DefaultSubscriber() {
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println(name + " onSubscribe by :" + subscription);
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object next) {
        System.out.println(name + " onNext by :" + next);

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " onError by :" + throwable.getMessage());

    }

    @Override
    public void onComplete() {
        System.out.println(name + " onComplete ");
    }

}
