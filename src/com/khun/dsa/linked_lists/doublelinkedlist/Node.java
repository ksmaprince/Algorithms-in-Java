package com.khun.dsa.linked_lists.doublelinkedlist;

public class Node<T> {
    Node<T> prev;
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return (next != null) ? data + " -> " + next.toString() : data + "";
    }
}
