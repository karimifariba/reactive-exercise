package com.example.reactive.sec02.helper;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
    public static List<String> getNames(int count) {
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            names.add(getName());
        }
        return names;
    }

    private static String getName() {
        System.out.println("generating name...");
        Util.sleep(1);
        return Util.faker().name().fullName();
    }

    public static Flux<String> getNameFlux(int count) {
        return  Flux.range(1,count)
                .map(i->getName());
    }
}
