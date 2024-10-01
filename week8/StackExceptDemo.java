import java.util.Scanner;
class PushException extends Exception {
    public PushException(String message) {
        super(message);
    }
}

class PopException extends Exception {
    public PopException(String message) {
        super(message);
    }
}

class Stack {
    private int[] array;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with a given capacity
    public Stack(int capacity) {
       
        this.capacity = capacity;
        this.storage = new int[capacity];
        this.top = -1;
    }

    // Push method to add an element to the stack
    public void push(int value) throws PushException {
        if (top == capacity - 1) { // Check if the stack is full
            throw new PushException("Stack is full, cannot push " + value);
        }
        storage[++top] = value; // Increment top and add the value
    }

    // Pop method to remove and return the top element of the stack
    public int pop() throws PopException {
        if (top == -1) { // Check if the stack is empty
            throw new PopException("Stack is empty, cannot pop");
        }
        return storage[top--]; // Return the top value and decrement top
    }

    // Method to peek at the top element without removing it
    public int peek() throws PopException {
        if (top == -1) {
            throw new PopException("Stack is empty, cannot peek");
        }
        return storage[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

// Main class to demonstrate stack usage and exception handling
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack with a capacity of 5

        try {
            // Pushing elements onto the stack
            for (int i = 0; i < 6; i++) { // Attempting to push 6 elements
                System.out.println("Pushing: " + i);
                stack.push(i);
            }
        } catch (PushException e) {
            System.out.println(e.getMessage()); // Handle push exception
        }

        try {
            // Popping elements from the stack
            for (int i = 0; i < 6; i++) { // Attempting to pop 6 elements
                System.out.println("Popped: " + stack.pop());
            }
        } catch (PopException e) {
            System.out.println(e.getMessage()); // Handle pop exception
        }
    }
}