/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Teenu
 */

public class StackQueueEnqueueFriendly {

    // Node for the stack
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Stack implementation
    class MyStack {
        Node top;

        void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }

        int pop() {
            if (top == null) {
                throw new IllegalStateException("Stack is empty");
            }

            int value = top.data;
            top = top.next;
            return value;
        }

        boolean isEmpty() {
            return top == null;
        }
    }

    MyStack stack1 = new MyStack();
    MyStack stack2 = new MyStack();

    // Enqueue friendly
    public void enqueue(int value) {
        stack1.push(value);
        System.out.println(value + " added to queue");
    }

    // Dequeue
    public int dequeue() {

        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Move elements to the second stack
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Remove the oldest element
        int removed = stack2.pop();

        // Move remaining elements back
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return removed;
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly q =
                new StackQueueEnqueueFriendly();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Removed: " + q.dequeue());

        q.enqueue(40);

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());
    }
}

