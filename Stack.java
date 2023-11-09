public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Push (add an element to the top of the stack)
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
    }

    // Pop (remove and return the top element)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Return a sentinel value for an empty stack
        }
        return stackArray[top--];
    }

    // Peek (view the top element without removing it)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Return a sentinel value for an empty stack
        }
        return stackArray[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display(); // Output: Stack: 1 2 3

        System.out.println("Peek: " + stack.peek()); // Output: Peek: 3

        System.out.println("Pop: " + stack.pop()); // Output: Pop: 3
        stack.display(); // Output: Stack: 1 2
    }
}
