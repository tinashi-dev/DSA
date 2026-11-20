/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




public class SinglyLinkedList {

    class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    // Insert at the beginning
    public void insertFirst(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertLast(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Search for a value
    public boolean search(int value) {

        Node temp = head;

        while (temp != null) {

            if (temp.value == value) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // Delete a value
    public void delete(int value) {

        if (head == null) {
            System.out.println("Nothing to delete");
            return;
        }

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               temp.next.value != value) {

            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Value not found");
        }
    }

    // Display all elements
    public void display() {

        Node temp = head;

        System.out.print("Linked List: ");

        while (temp != null) {

            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);

        list.display();

        System.out.println("Search 30: " + list.search(30));

        list.delete(20);

        list.display();

        list.insertFirst(5);

        list.display();
    }
}
