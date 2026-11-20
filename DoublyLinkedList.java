/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */






public class DoublyLinkedList {

    class Node {

        int value;
        Node previous;
        Node next;

        Node(int value) {
            this.value = value;
            previous = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;

    // Insert at the beginning
    public void insertFirst(int value) {

        Node newNode = new Node(value);

        if (head == null) {

            head = newNode;
            tail = newNode;

        } else {

            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertLast(int value) {

        Node newNode = new Node(value);

        if (tail == null) {

            head = newNode;
            tail = newNode;

        } else {

            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    // Delete a value
    public void delete(int value) {

        Node temp = head;

        while (temp != null && temp.value != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.previous != null) {
            temp.previous.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.previous = temp.previous;
        } else {
            tail = temp.previous;
        }
    }

    // Display from head to tail
    public void displayForward() {

        Node temp = head;

        System.out.print("Forward: ");

        while (temp != null) {

            System.out.print(temp.value + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Display from tail to head
    public void displayBackward() {

        Node temp = tail;

        System.out.print("Backward: ");

        while (temp != null) {

            System.out.print(temp.value + " <-> ");
            temp = temp.previous;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertFirst(10);

        list.displayForward();
        list.displayBackward();

        list.delete(30);

        list.displayForward();
        list.displayBackward();
    }
}
