package com.example.reactive.sec02;

import com.example.reactive.common.Util;
import com.example.reactive.sec02.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;

public class Lec11StockAssignment {
    public static void main(String[] args) throws InterruptedException {
//        StockPricePublisher.getStockPrice().subscribe(Util.onNext());
//        Util.sleep(100);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        StockPricePublisher.getStockPrice().subscribeWith(
                new Subscriber<Integer>() {
                    private Subscription subscription;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription=subscription;
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer i) {
                        System.out.println("onNext: "+i);
                        if(i<90 || i>110){
                           this.subscription.cancel();
                            countDownLatch.countDown();
                            System.out.println("canceled ");
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        countDownLatch.countDown();
                        System.out.println("error ");
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );
//        Util.sleep(300);
        countDownLatch.await();
    }
}
