package com.comrade.do_while;

public class DoWhileClient {
    public static void main(String[] args) {
        doWhileStatement();
        doWhileUnreachableStatement();
    }

    private static void doWhileUnreachableStatement() {
        do {
            System.out.println("Shiva Dasari");
        } while (false);
        System.out.println("Shiva");
    }

    private static void doWhileStatement() {
        int COUNTER = 0;
        do {
            COUNTER++;
            System.out.println("COUNTER:" + COUNTER);
        } while (COUNTER < 10);
    }
}
