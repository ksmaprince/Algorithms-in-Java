package com.khun.dsa.recursive_backtracking.recursive;

public class MyFactorial {
    public int factorial(int n){
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        MyFactorial myFactorial = new MyFactorial();
        System.out.println("0! = "+ myFactorial.factorial(0));
        System.out.println("1! = "+ myFactorial.factorial(1));
        System.out.println("2! = "+ myFactorial.factorial(2));
        System.out.println("4! = "+ myFactorial.factorial(4));
        System.out.println("6! = "+ myFactorial.factorial(6));
        System.out.println("10! = "+ myFactorial.factorial(10));
    }
}
