package com.VinhHua;

public class SumTester {
    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println("Sum of integers from 1 to 100 is: " + sum.sum(100));
        System.out.println("Sum of integers from 100 to 1000 is : " + sum.sum(100, 1000));
    }
}
