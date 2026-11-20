/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();

    // Insert a new value
    public void enqueue(int value) {

        moveElements(tempStack, mainStack);

        mainStack.push(value);

        moveElements(mainStack, tempStack);

        // Restore the original order
        moveElements(tempStack, mainStack);

        System.out.println(value + " inserted into queue");
    }

    // Move all elements from one stack to another
    private void moveElements(Stack<Integer> source,
                              Stack<Integer> destination) {

        while (!source.isEmpty()) {
            destination.push(source.pop());
        }
    }

    // Remove the oldest value
    public int dequeue() {

        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return mainStack.pop();
    }

    // Display the queue
    public void display() {

        if (mainStack.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = mainStack.size() - 1; i >= 0; i--) {
            System.out.print(mainStack.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue =
                new StackQueueDequeueFriendly();

        queue.enqueue(15);
        queue.enqueue(25);
        queue.enqueue(35);

        queue.display();

        System.out.println("Deleted: " + queue.dequeue());

        queue.enqueue(45);

        queue.display();

        System.out.println("Deleted: " + queue.dequeue());
    }
}
