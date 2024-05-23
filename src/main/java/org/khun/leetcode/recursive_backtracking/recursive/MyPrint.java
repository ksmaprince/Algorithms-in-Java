package org.khun.leetcode.recursive_backtracking.recursive;

public class MyPrint {
    public int print(int n){
        if (n == 0) return 0;
        else {
            System.out.println(n);
            return print(n - 1);
        }
    }

    public static void main(String[] args) {
        MyPrint myPrint = new MyPrint();
        myPrint.print(4);
    }
}
