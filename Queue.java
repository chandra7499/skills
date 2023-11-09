public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Enqueue (add an element to the rear of the queue)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize; // Circular queue
        queueArray[rear] = value;
        currentSize++;
    }

    // Dequeue (remove and return the front element)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Return a sentinel value for an empty queue
        }
        int dequeuedValue = queueArray[front];
        front = (front + 1) % maxSize; // Circular queue
        currentSize--;
        return dequeuedValue;
    }

    // Peek (view the front element without removing it)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Return a sentinel value for an empty queue
        }
        return queueArray[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int index = front;
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize; // Circular queue
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display(); // Output: Queue: 1 2 3

        System.out.println("Peek: " + queue.peek()); // Output: Peek: 1

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 1
        queue.display(); // Output: Queue: 2 3
    }
}





