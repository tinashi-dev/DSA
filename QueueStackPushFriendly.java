/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Teenu
 */


public class QueueStackPushFriendly {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    class MyQueue {
        Node front, rear;
        int count = 0;

        void enqueue(int value) {
            Node newNode = new Node(value);

            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }

            count++;
        }

        int dequeue() {
            if (front == null) {
                throw new IllegalStateException("Queue is empty");
            }

            int value = front.data;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            count--;
            return value;
        }

        boolean isEmpty() {
            return count == 0;
        }
    }

    MyQueue q1 = new MyQueue();
    MyQueue q2 = new MyQueue();

    // Push takes
    public void push(int value) {
        q1.enqueue(value);
        System.out.println(value + " added");
    }

    // Pop takes 
    public int pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (q1.count > 1) {
            q2.enqueue(q1.dequeue());
        }

        int removed = q1.dequeue();

        MyQueue temp = q1;
        q1 = q2;
        q2 = temp;

        return removed;
    }

    public static void main(String[] args) {

        QueueStackPushFriendly s = new QueueStackPushFriendly();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Removed: " + s.pop());

        s.push(40);

        System.out.println("Removed: " + s.pop());
        System.out.println("Removed: " + s.pop());
        System.out.println("Removed: " + s.pop());
    }
}

