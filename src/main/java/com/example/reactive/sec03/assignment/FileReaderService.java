package com.example.reactive.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {
    private Callable<BufferedReader> openReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> getReader() {
        return (buf, sink) -> {
            try {
                String line = buf.readLine();
                if (line != null) {
                    sink.next(line);
                } else {
                    sink.complete();
                }
            } catch (IOException e) {
                sink.error(e);
            }
            return buf;
        };
    }

    private Consumer<BufferedReader> closeReader() {
        return (buf) -> {
            try {
                buf.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public Flux<String> read(Path path) {
        return Flux.generate(
                openReader(path), getReader(), closeReader()
        );
    }
}
