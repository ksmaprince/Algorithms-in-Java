package com.khun.dsa.linked_lists.singlylinkedlists;

public class CircularSinglyLinkedList<T> {
    private Node tail;
    private int size = 0;

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
        } else {
            newNode.next = tail.next;
        }
        tail.next = newNode;
        size++;
    }

    public void addLast(T data) {
        addFirst(data);
        tail = tail.next;
    }

    public void addAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = tail.next;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void deleteFirst() {
        if (tail == null) throw new IllegalStateException("List is Empty");

        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        size--;
    }

    public void deleteLast() {
        if (tail == null) throw new IllegalStateException("List is Empty");
        if (tail.next == tail) {
            tail = null;
        } else {
            Node current = tail.next;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
        size--;
    }

    public void deleteAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bound");

        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        Node current = tail.next;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public Node<T> getAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bound");

        Node current = tail.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        if (size <= 0) return "Empty List";
        StringBuilder str = new StringBuilder();
        Node current = tail.next;
        do {
            str.append(current.data).append(" ");
            current = current.next;
        } while (current != tail.next);
        return str.toString();
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();

        System.out.println(list);
        list.addFirst(0);
        list.addFirst(1);
        System.out.println(list);
        System.out.println("Size: " + list.size);
        list.addLast(2);
        System.out.println(list);
        System.out.println("Size: " + list.size);

        list.addAt(3, 8);
        System.out.println(list);
        System.out.println("Size: " + list.size);
        list.addAt(3, 6);
        System.out.println(list);
        System.out.println("Size: " + list.size);

        System.out.println("Get: "+list.getAt(4).data);
//        list.deleteFirst();
//        System.out.println(list);
//        System.out.println("Size: " + list.size);
//        list.deleteLast();
//        System.out.println(list);
//        System.out.println("Size: " + list.size);
    }
}
