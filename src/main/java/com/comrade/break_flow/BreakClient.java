package com.comrade.break_flow;

public class BreakClient {
    public static void main(String[] args) {
        breakStatement();
        breakSimulatorSingleMethod();
        breakSimulatorDoubleLoopMethod();
    }

    private static void breakStatement() {
        int[] MARKS_LIST= {10,87,98,25,67};
        for (int i = 0; i < MARKS_LIST.length; i++) {
            if(MARKS_LIST[i]==98) {
                break;
            }
            System.out.println(MARKS_LIST[i]);
        }
    }
    private static void breakSimulatorSingleMethod() {
        for (int i = 1; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println("" + i);
        }
    }

    private static void breakSimulatorDoubleLoopMethod() {
        for (int i = 1; i < 10; i++) {
            for(int j=1;j<10;j++) {
                if (i == 4 && j==4) {
                    break;
                }
                System.out.println("i: " + i+" j:"+j);
            }

        }
    }
}
