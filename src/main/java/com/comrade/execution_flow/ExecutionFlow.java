package com.comrade.execution_flow;

public class ExecutionFlow {
    {
        System.out.println("INSTANCE BLOCK");
    }
    static {
        System.out.println("STATIC BLOCK");
    }

    public static void staticMethod() {
        System.out.println("STATIC METHOD");
    }

    public void instanceMethod() {
        System.out.println("INSTANCE METHOD");
    }
    public ExecutionFlow() {
        System.out.println("CONSTRUCTOR");
    }

    public static void main(String[] args) {
        ExecutionFlow executionFlow=new ExecutionFlow();
        ExecutionFlow.staticMethod();
        executionFlow.instanceMethod();
    }
}
