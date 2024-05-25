package com.khun.dsa.linked_lists.singlylinkedlists;

public class SinglyLinkedLists<T> {

    private Node head;

    private boolean isEmpty() {
        return head == null;
    }

    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T data) {
        if (isEmpty()) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addAt(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Index out of bound");
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void deleteAt(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Index out of bound");
            }
            current = current.next;
        }
        current.next = current.next.next;
    }

    public Node<T> getAt(int index){
        if (index<0 || index>=length())
            throw new IndexOutOfBoundsException("Index out of bound");

        Node current = head;
        for (int i = 0; i<index; i++){
            current = current.next;
        }
        return current;
    }

    public Node<T> findMiddle() {
        if (isEmpty()) throw new IllegalStateException("Index can't be negative");
        int middleIndex = length() / 2;
        return getAt(middleIndex);
    }

    @Override
    public String toString() {
        return (isEmpty()) ? "Empty List" : head.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedLists<Integer> list = new SinglyLinkedLists<>();
        System.out.println(list);

        //Test Add First
//        list.addFirst(1);
//        list.addFirst(0);
//        System.out.println(list);


        // Test Add Last
//        list.addLast(1);
//        list.addLast(2);
//        System.out.println(list);

//        list.addAt(0, 10);
//        list.addAt(-1, 8);
//        list.addAt(4, 8);
//        System.out.println(list);

        //delete first with empty
//        list.deleteFirst();
//        System.out.println(list);

        //delete first with existing data
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list);

        list.deleteFirst();
        System.out.println(list);

        list.deleteLast();
        System.out.println(list);

    }
}
