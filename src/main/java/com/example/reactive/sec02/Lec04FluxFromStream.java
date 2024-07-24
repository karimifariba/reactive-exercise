package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        var stream= Arrays.asList('a','b','c','d','e','f','g','h').stream();
         Flux.fromStream(stream).subscribe(Util.onNext());
    }
}
