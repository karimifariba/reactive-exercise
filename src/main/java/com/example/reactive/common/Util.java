package com.example.reactive.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Faker faker() {
        return FAKER;
    }

    public static Consumer<Object> onNext() {
        return s -> System.out.println("OnNext:" + s);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("OnError:" + e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed");
    }

    public static void sleep(int duration) {
        try {
            Thread.sleep(1000 * duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Subscriber subscriber() {
        return new DefaultSubscriber();
    }
    public static Subscriber subscriber(String name){
        return new DefaultSubscriber(name);
    }
}
