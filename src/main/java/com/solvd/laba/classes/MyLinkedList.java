package com.solvd.laba.classes;

import java.util.Iterator;

public class MyLinkedList<T> {

//    Each node in the linked list will hold a value of type T
    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

//    The head of the linked list points to the first node
    private Node<T> head;

//    The tail of the linked list points to the last node
    private Node<T> tail;

//    The size of the linked list is stored in a separate variable for easy access
    private int size;

//    Constructor creates an empty linked list with size 0
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

//    Returns the number of elements in the linked list
    public int size() {
        return size;
    }

//    returns value of linked list i element
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

//    returns true if the linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }

//    adds a new element to the tail of the linked list
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

//        If the linked list is empty, set the new node as both head and tail
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }

//        updates tail pointer and adds newNode to the tail of linked list
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

//    Removes the first element from the linked list, if it exists and equals value
    public void remove (T value) {
        Node<T> prev = null;
        Node<T> curr = head;

//        scanning the linked list until find the element == value
        while (curr != null && !curr.value.equals(value)) {
            prev = curr;
            curr = curr.next;
        }
//        If the value was not found
        if (curr == null) {
            return;
        }

//        If removing the head of the linked list, update the head pointer
        if (prev == null) {
            head = curr.next;
        }
//        if no - update the previous node's next pointer to skip the node to remove
        else {
            prev.next = curr.next;
        }

//        If the node to remove is the tail of the linked list, update the tail pointer
        if (curr == tail) {
            tail = prev;
        }

        size --;
    }

//    Returns an iterator over the elements in the linked list
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

//    Private inner class that implements the Iterator interface
    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> curr;

        public MyLinkedListIterator() {
            curr = head;
        }

//    Returns true if there are more elements in the linked list to iterate over
        public boolean hasNext() {
            return curr != null;
        }

//    Returns the next element in the linked list and advances the iterator
        public T next() {
            T value = curr.value;
            curr = curr.next;
            return value;
        }
    }
}