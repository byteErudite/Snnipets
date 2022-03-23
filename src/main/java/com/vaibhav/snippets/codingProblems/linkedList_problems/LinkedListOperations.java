package com.vaibhav.snippets.codingProblems.linkedList_problems;

public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.add(1);
        list.add(3);
        list.add(4);

        list.print();
        list.reverse();
        list.print();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;

    LinkedList(int data) {
        head = new Node(data);
    }

    public void add(int data) {
        Node trev = head;
        while (trev.next != null) {
            trev = trev.next;
        }
        Node newNode = new Node(data);
        trev.next = newNode;
    }

    public void delete(Node node) {
        if (node == null) {
            return;
        }
        if (node == head) {
            head = null;
        }
        Node trev = head;
        while(trev.next != node) {
            trev = trev.next;
        }
        trev.next = trev.next.next;
    }

    public void reverse() {
        if (head.next == null) {
            return;
        } else if (head.next.next == null) {
            Node sec = head.next;
            sec.next = head;
            head.next = null;
            head = sec;
            return;
        }

        Node prev = null;
        Node curr = head;
        Node next ;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print() {
        System.out.println();
        Node trev = head;
        while(trev != null) {
            System.out.print(trev.data + " ");
            trev = trev.next;
        }
    }
}
