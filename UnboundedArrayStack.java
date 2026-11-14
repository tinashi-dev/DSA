/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Teenu
 */

public class UnboundedArrayStack {

    int arr[];
    int top;
    int capacity;

    // Create stack with initial size
    public UnboundedArrayStack() {
        capacity = 4;
        arr = new int[capacity];
        top = -1;
    }

    // Increase array size
    public void grow() {

        capacity = capacity * 2;

        int newArr[] = new int[capacity];

        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // Decrease array size
    public void shrink() {

        if (capacity > 4 && top + 1 <= capacity / 4) {

            capacity = capacity / 2;

            int newArr[] = new int[capacity];

            for (int i = 0; i <= top; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }
    }

    // Add element
    public void push(int value) {

        if (top == capacity - 1) {
            grow();
        }

        arr[++top] = value;

        System.out.println(value + " added");
    }

    // Remove element
    public int pop() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int removed = arr[top];
        top--;

        shrink();

        return removed;
    }

    // Display stack
    public void display() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack: ");

        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {

        UnboundedArrayStack s = new UnboundedArrayStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        s.display();

        System.out.println("Removed: " + s.pop());
        System.out.println("Removed: " + s.pop());
        System.out.println("Removed: " + s.pop());

        s.display();

        System.out.println("Current size: " + s.size());
    }
}

