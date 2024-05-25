package com.khun.dsa.linked_lists.singlylinkedlists;

public class Node<T> {
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
