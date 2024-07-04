package com.comrade;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class ContinuationsInternals {
    public static void main(String[] args) {
        int max = 10;
        int yieldInterval = 1;
        var cont = generateContinuation(max, yieldInterval);
        for (int i = 1; i < max; i++) {
            cont.run();
        }
    }

    private static Continuation generateContinuation(int max, int yieldInterval) {
        var continuationScope = new ContinuationScope("dear-comrade");

        var continuation = new Continuation(continuationScope, ()->{
            for (int i=1;i<=max;i++ ){
                System.out.println("Dear Comrade loop value :"+i);
                if (i/yieldInterval==0){
                    Continuation.yield(continuationScope);
                }
            }
        }) ;
        return continuation;
    }
}
