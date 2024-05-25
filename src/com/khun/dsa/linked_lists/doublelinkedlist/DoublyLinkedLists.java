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
        if (index < 0 || index>length()) throw new IndexOutOfBoundsException("Index Out of Bound");
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == length()){
            addLast(data);
            return;
        }
        Node current = head;
        Node newNode = new Node(data);
        for (int i = 0; i < index - 1; i++) {
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
        if (index == length() - 1){
            deleteLast();
            return;
        }
        Node current = head;
        for (int i = 0; i<index; i++){
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
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

    @Override
    public String toString() {
        return (isEmpty()) ? "Empty List" : head.toString();
    }


    public static void main(String[] args) {
        DoublyLinkedLists<Integer> list = new DoublyLinkedLists<>();
        System.out.println(list);

        list.addFirst(1);
        list.addFirst(0);
        System.out.println(list);

        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);
        System.out.println("Length/Size : " + list.length());

        list.addAt(5, 1);
        System.out.println(list);

        list.deleteAt(0);
        System.out.println(list);

        list.deleteAt(1);
        System.out.println(list);

        list.deleteLast();
        System.out.println(list);

        System.out.println(list.getAt(0).data);

    }
}
