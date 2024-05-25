package com.khun.dsa.linked_lists.doublelinkedlist;

public class DoublyLinkedLists<T> {
    Node head;

    private boolean isEmpty() {
        return head == null;
    }

    public int length() {
        int len = 0;
        Node current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
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
        newNode.prev = current;
    }

    public void addAt(T data, int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index can't be negative value");
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        Node newNode = new Node(data);
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) throw new IndexOutOfBoundsException("Index out of bound");
            current = current.next;
        }
        newNode.prev = current;
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
    }

    public void deleteFirst(){
        if (isEmpty()) throw new IllegalStateException("Empty List");
        head = head.next;
    }

    public void deleteLast(){
        if (isEmpty()) throw new IllegalStateException("Empty List");
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.prev.next = null;
    }

    public void deleteAt(int index){
        if (index<0) throw new IndexOutOfBoundsException("Index can't be negative");
        if (index == 0){
            deleteFirst();
            return;
        }
        Node prep = head;
        Node succ = head.next;
        for (int i = 0; i<index - 1; i++){
            if (prep == null || succ == null) throw new IndexOutOfBoundsException("Index out of bound");
            prep = prep.next;
            succ = succ.next;
        }
        prep.next = succ.next;
        succ.next.prev = prep;
    }

    @Override
    public String toString() {
        return (isEmpty()) ? "Empty List" : head.toString();
    }


    public static void main(String[] args) {
        DoublyLinkedLists<Integer> doublyLinkedLists = new DoublyLinkedLists<>();
        System.out.println(doublyLinkedLists);

        doublyLinkedLists.addFirst(1);
        System.out.println(doublyLinkedLists);


        doublyLinkedLists.addLast(2);
        doublyLinkedLists.addLast(3);
        doublyLinkedLists.addLast(4);
        System.out.println(doublyLinkedLists);
        System.out.println("Length/Size : " + doublyLinkedLists.length());

        doublyLinkedLists.addAt(5, 1);
        System.out.println(doublyLinkedLists);

        doublyLinkedLists.deleteAt(0);
        System.out.println(doublyLinkedLists);

        doublyLinkedLists.deleteAt(1);
        System.out.println(doublyLinkedLists);

        doublyLinkedLists.deleteLast();
        System.out.println(doublyLinkedLists);



    }
}
