//package ooplab.week8;
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
    private final int capacity = 5;

    public int getcap(){return capacity;}
    public Stack() {
        array = new int[capacity];
        this.top = -1;
    }

    public void push(int value) throws PushException {
        if (top == capacity-1)
            throw new PushException("Stack is full, cannot push " + value);
        array[++top] = value;
    }

    public int pop() throws PopException {
        if (top == -1) {
            throw new PopException("Stack is empty, cannot pop");
        }
        return array[top--];
    }
}

public class StackExceptDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        try {
            for (int i = 0; i <= stack.getcap(); i++) {
                System.out.println("Pushing: " + i);
                stack.push(i);
            }
        }
        catch (PushException e) {
            System.out.println(e.getMessage());
        }
        try {
            for (int i = 0; i <= stack.getcap(); i++) {
                System.out.println("Popped: " + stack.pop());
            }
        }
        catch (PopException e) {
            System.out.println(e.getMessage());
        }
    }
}