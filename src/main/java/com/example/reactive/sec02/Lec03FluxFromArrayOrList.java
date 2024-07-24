package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        var list= Arrays.asList(1,2,3,4,5);
        var flux= Flux.fromIterable(list).subscribe(Util.onNext());
        Integer[] array={1,2,3,4,5,6,7};
        var flux2= Flux.fromArray(array).subscribe(Util.onNext());
    }
}
