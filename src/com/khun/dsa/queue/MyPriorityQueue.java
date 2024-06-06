package com.khun.dsa.queue;

public class MyPriorityQueue<T extends Comparable<T>> {
    private T[] heap;
    private int size;
    private int capacity;

    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = (T[]) new Comparable[capacity + 1];
        size = 0;
    }

    public void enqueue(T data) {
        if (size == capacity) throw new IllegalStateException("PriorityQueue is full");
        heap[++size] = data;
        moveUp(size);
    }

    public T dequeue() {
        if (size == 0) throw new IllegalStateException("PriorityQueue is empty");

        T min = heap[1];
        swap(1, size--);
        moveDown(1);
        heap[size + 1] = null;
        return min;
    }

    public T peek() {
        if (size == 0) throw new IllegalStateException("PriorityQueue is empty");
        return heap[1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void moveUp(int k) {
        while (k > 1 && heap[k].compareTo(heap[k / 2]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void moveDown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && heap[j].compareTo(heap[j + 1]) > 0) j++;
            if (heap[k].compareTo(heap[j]) <= 0) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<>(10);

        // Enqueue
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(1);
        priorityQueue.enqueue(2);

        // Peek
        System.out.println("Peek: " + priorityQueue.peek()); // Outputs 1

        // Dequeue
        System.out.println("Removed: " + priorityQueue.dequeue()); // Outputs 1
        System.out.println("Removed: " + priorityQueue.dequeue()); // Outputs 2
        System.out.println("Removed: " + priorityQueue.dequeue()); // Outputs 3

        // Checking if the priority queue is empty
        System.out.println("Is empty: " + priorityQueue.isEmpty()); // Outputs true
    }
}
