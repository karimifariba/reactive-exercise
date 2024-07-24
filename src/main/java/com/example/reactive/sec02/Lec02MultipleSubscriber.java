package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscriber {
    public static void main(String[] args) {
        var flux=Flux.just(1,2,3,4,5,6,7,8,9);
        flux.subscribe(i-> System.out.println("flux1"+ i));
        flux.subscribe(i-> System.out.println("flux2"+ i));
        flux.subscribe(i-> System.out.println("flux3"+ i));
        flux.filter(i->i%2==0)
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());

    }
}
