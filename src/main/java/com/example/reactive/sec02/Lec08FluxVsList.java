package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import com.example.reactive.sec02.helper.NameGenerator;

public class Lec08FluxVsList {
    public static void main(String[] args) {
        var names= NameGenerator.getNames(10);
        System.out.println(names);

        System.out.println("By flux..................................");

        NameGenerator.getNameFlux(10)
                .subscribe(Util.onNext());
    }
}
