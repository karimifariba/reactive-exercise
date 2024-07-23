package com.example.reactive.sec01;

import com.example.reactive.common.Util;
import com.example.reactive.sec01.assignment.FileService;

public class Lec08AssignmentDemo {
    public static void main(String[] args) {
        FileService.write("file1.txt", "write something1")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        FileService.write("file1.txt", "write something2")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        FileService.write("file1.txt", "write something3")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        FileService.write("file1.txt", "write something4")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.read("file1.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file2.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete())
                ;
    }

}
