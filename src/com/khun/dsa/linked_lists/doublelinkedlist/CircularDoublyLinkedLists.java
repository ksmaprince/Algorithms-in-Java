package com.khun.dsa.linked_lists.doublelinkedlist;


public class CircularDoublyLinkedLists<T> {
    private Node head;
    private Node tail;
    private int size;

    private boolean isEmpty() {
        return false;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAt(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bound");

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    public void deleteFirst() {
        if (head == null) throw new IllegalStateException("List is Empty");

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    public void deleteLast() {
        if (tail == null) throw new IllegalStateException("List is Empty");
        if (head == tail) {
            head = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    public Node<T> getAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bound");
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        if (head == null) return "List is empty";
        StringBuilder sb = new StringBuilder();
        Node current = head;
        do {
            sb.append(current.data).append(" ");
            current = current.next;
        } while (current != head);
        return sb.toString();
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
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedLists<Integer> lists = new CircularDoublyLinkedLists<>();

        lists.addFirst(0);
        lists.addFirst(1);
        System.out.println(lists);
        System.out.println("Size: " + lists.size);
        lists.addLast(2);
        lists.addLast(3);
        System.out.println(lists);
        System.out.println("Size: " + lists.size);

        lists.addAt(4, 8);
        System.out.println(lists);
        System.out.println("Size: " + lists.size);

        System.out.println("Get: "+lists.getAt(4).data);

        lists.deleteFirst();
        System.out.println(lists);
        System.out.println("Size: " + lists.size);

        lists.deleteLast();
        System.out.println(lists);
        System.out.println("Size: " + lists.size);

        lists.deleteAt(1);
        System.out.println(lists);
        System.out.println("Size: " + lists.size);
    }
}
