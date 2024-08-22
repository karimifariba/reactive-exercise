package com.example.reactive.sec03;

import com.example.reactive.common.Util;
import com.example.reactive.sec03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        FileReaderService service = new FileReaderService();
        Path path= Paths.get("src/main/resources/assignment/sec03/File01.txt");
        service.read(path).delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleep(2000);
    }
}
