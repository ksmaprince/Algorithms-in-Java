package com.khun.dsa.queue;

public class LinkListQueue<T> {
    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public T dequeue() {
        if (front == null) throw new IllegalStateException("Queue is empty");

        Node<T> temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return temp.data;
    }

    public T peek(){
        if (front == null) throw new IllegalStateException("Queue is empty");
        return front.data;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public static void main(String[] args) {
        LinkListQueue<Integer> queue = new LinkListQueue<>();

        // Enqueue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue
        System.out.println("Removed: " + queue.dequeue()); // Outputs 1
        System.out.println("Removed: " + queue.dequeue()); // Outputs 2

        // Peek
        System.out.println("Peek: " + queue.peek()); // Outputs 3

        // Check if queue is empty
        System.out.println("Is empty: " + queue.isEmpty()); // Outputs false
    }
}
