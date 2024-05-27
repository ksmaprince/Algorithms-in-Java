package com.khun.dsa.linked_lists.doublelinkedlist;

public class DoublyLinkedLists<T> {
    private Node head;
    private int size = 0;

    private boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
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
        size++;
    }

    public void addAt(T data, int index) {
        if (index < 0 || index>size) throw new IndexOutOfBoundsException("Index Out of Bound");
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size){
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
        size++;
    }

    public void deleteFirst(){
        if (isEmpty()) throw new IllegalStateException("Empty List");
        head = head.next;
        size--;
    }

    public void deleteLast(){
        if (isEmpty()) throw new IllegalStateException("Empty List");
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.prev.next = null;
        size--;
    }

    public void deleteAt(int index){
        if (index<0 || index>size-1) throw new IndexOutOfBoundsException("Index out of bound");
        if (index == 0){
            deleteFirst();
            return;
        }
        if (index == size - 1){
            deleteLast();
            return;
        }
        Node current = head;
        for (int i = 0; i<index; i++){
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    public Node<T> getAt(int index){
        if (index<0 || index>=size)
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
        System.out.println("Size: "+list.size);

        list.addFirst(1);
        list.addFirst(0);
        System.out.println(list);
        System.out.println("Size: "+list.size);

        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);
        System.out.println("Size: "+list.size);

        list.addAt(5, 1);
        System.out.println(list);
        System.out.println("Size: "+list.size);

        list.deleteAt(1);
        System.out.println(list);
        System.out.println("Size: "+list.size);

        list.deleteLast();
        System.out.println(list);
        System.out.println("Size: "+list.size);

        System.out.println(list.getAt(0).data);

    }
}
