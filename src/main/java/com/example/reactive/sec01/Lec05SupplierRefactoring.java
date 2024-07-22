package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.function.Supplier;

public class Lec05SupplierRefactoring {
    public static void main(String[] args) {
        var mono1=getName(1);
        var name=getName(2).subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        getName(3);
//        Util.sleep(4);

    }
    private  static Mono<String> getName(int cullNumber){
        System.out.println("culled"+cullNumber);
        return Mono.fromSupplier( ()->{
            System.out.println("generating:"+cullNumber);
            Util.sleep(3);
            return Util.faker().name().fullName();

        }).map(String::toUpperCase);
    }
}
