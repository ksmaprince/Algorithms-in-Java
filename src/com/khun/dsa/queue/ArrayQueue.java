package com.khun.dsa.queue;

public class ArrayQueue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(T data) {
        if (isFull()) throw new IllegalStateException("Queue is full");

        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        T data = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public T peek(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return queue[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        // Enqueue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Trying to enqueue into a full queue
        // queue.enqueue(6); // This will throw an IllegalStateException

        // Dequeue
        System.out.println("Removed: " + queue.dequeue()); // Outputs 1
        System.out.println("Removed: " + queue.dequeue()); // Outputs 2

        // Peek
        System.out.println("Peek: " + queue.peek()); // Outputs 3

        // Enqueue after dequeueing
        queue.enqueue(6);
        System.out.println("Peek: " + queue.peek()); // Outputs 3

        // Dequeue remaining elements
        while (!queue.isEmpty()) {
            System.out.println("Removed: " + queue.dequeue());
        }
    }
}
