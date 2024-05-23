package com.khun.dsa.recursive_backtracking.backtracking;

import java.util.Arrays;

public class MyKString {
    int[] A = null;
    public void kString(int n, int k){
        if (n<1){
            System.out.println(Arrays.toString(A));
        }else {
            for (int j = 0; j< k; j++){
                A[n-1] = j;
                kString(n-1, k);
            }
        }
    }

    public static void main(String[] args) {
        MyKString myKString = new MyKString();
        myKString.A = new int[4];
        myKString.kString(4, 2);
    }
}
