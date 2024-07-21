package com.example.reactive.common;

import java.util.function.Consumer;

public class Util {
    public static Consumer<Object> onNext(){
        return s -> System.out.println("OnNext:"+s);
    }
    public static Consumer<Throwable> onError(){
        return e-> System.out.println("OnError:"+e.getMessage());
    }
    public static Runnable onComplete(){
        return ()->System.out.println("Completed");
    }
}
