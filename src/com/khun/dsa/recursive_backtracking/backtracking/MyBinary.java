package com.khun.dsa.recursive_backtracking.backtracking;

import java.util.Arrays;

public class MyBinary {

    int[] A = null;

    public void Binary(int n) {
        if (n < 1) System.out.println(Arrays.toString(A));
        else {
            A[n - 1] = 0;
            Binary(n - 1);
            A[n - 1] = 1;
            Binary(n - 1);
        }
    }

    public static void main(String[] args) {
        MyBinary myBinary = new MyBinary();
        myBinary.A = new int[3];
        myBinary.Binary(myBinary.A.length);
    }
}
