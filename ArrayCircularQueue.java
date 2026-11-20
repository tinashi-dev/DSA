/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class ArrayCircularQueue {

    private int[] data;
    private int front;
    private int rear;
    private int count;

    public ArrayCircularQueue(int size) {

        data = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Check whether the queue is full
    public boolean isFull() {
        return count == data.length;
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Insert a new value
    public void enqueue(int value) {

        if (isFull()) {
            System.out.println("Cannot insert. Queue is full.");
            return;
        }

        rear = (rear + 1) % data.length;
        data[rear] = value;
        count++;

        System.out.println(value + " inserted");
    }

    // Remove a value
    public int dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int removed = data[front];

        front = (front + 1) % data.length;
        count--;

        return removed;
    }

    // Display queue contents
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue contents: ");

        for (int i = 0; i < count; i++) {

            int position = (front + i) % data.length;
            System.out.print(data[position] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        queue.display();

        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(400);
        queue.enqueue(500);
        queue.enqueue(600);

        queue.display();
    }
}
