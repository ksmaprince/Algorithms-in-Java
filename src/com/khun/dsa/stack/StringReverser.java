package com.khun.dsa.stack;

public class StringReverser {

    public static String reverseString(String str) {
        StackX stackX = new StackX<Character>(str.length());
        for (char ch: str.toCharArray()){
            stackX.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stackX.isEmpty()){
            sb.append(stackX.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello World")); // Expected output : dlroW olleH
    }
}
