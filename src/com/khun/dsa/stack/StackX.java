package com.khun.dsa.stack;

public class StackX<T> {
    private int maxSize;
    private T[] stackArray;
    private int top;

    public StackX(int size) {
        maxSize = size;
        stackArray = (T[]) new Object[size];
        top = -1;
    }

    public void push(T data) {
        if (isFull()) throw new IllegalStateException("Stack is full");
        stackArray[++top] = data;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stackArray[top--];
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        StackX stackX = new StackX(10);
        stackX.push(20);
        stackX.push(40);
        stackX.push(60);
        stackX.push(80);

        System.out.println(stackX.pop());
        System.out.println(stackX.pop());
        System.out.println(stackX.pop());
        System.out.println(stackX.peek());
    }

}
