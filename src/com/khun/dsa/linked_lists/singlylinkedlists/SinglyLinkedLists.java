package com.khun.dsa.linked_lists.singlylinkedlists;

public class SinglyLinkedLists<T> {

    private Node head;

    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
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
            if (current == null) {
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

    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public Node<T> findMiddle(){
        if (isEmpty()) throw new  IllegalStateException("Index can't be negative");
        int middleIndex = length()/2;
        Node<T> current = head;
        for (int i = 0; i<middleIndex ; i++){
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        return (isEmpty()) ? "Empty List" : head.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        SinglyLinkedLists<Integer> list = new SinglyLinkedLists<>();

        System.out.println(list);
        // Add elements to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println(list); // Output: 1 2 3

        // Add element at the beginning
        list.addFirst(0);
        System.out.println(list); // Output: 0 1 2 3

        // Add element at a specific position
        list.addAt(2, 5);
        System.out.println(list); // Output: 0 1 5 2 3

        System.out.println(list.findMiddle().data);

        // Delete the first element
        list.deleteFirst();
        System.out.println(list); // Output: 1 5 2 3

        // Delete the last element
        list.deleteLast();
        System.out.println(list); // Output: 1 5 2

        // Delete an element at a specific position
        list.deleteAt(1);
        System.out.println(list);// Output: 1 2

        // Print the length of the list
        System.out.println("Length of the list: " + list.length()); // Output: 2

        // Check if the list is empty
        System.out.println("Is the list empty? " + list.isEmpty()); // Output: false
    }
}
