package com.comrade.continue_flow;

public class ContinueClient {
    public static void main(String[] args) {
        singleLoopContinueCondition();
        doubleLoopContinueCondition();
    }

    private static void doubleLoopContinueCondition() {
        for (int i = 1; i < 8; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
    }

    private static void singleLoopContinueCondition() {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                if (i == 4 && j == 4) {
                    continue;
                }
                System.out.println("i:"+i+", j:"+j);
            }
        }
    }
}
