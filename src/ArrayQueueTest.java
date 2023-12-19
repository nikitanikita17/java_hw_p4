package lab21;

// Interface defining the methods for the queue
interface Queue<T> {
    void enqueue(T item);     // Add an item to the queue
    T element();              // Get the first element in the queue
    T dequeue();              // Delete and return the first item in the queue
    int size();               // Get the current queue size
    boolean isEmpty();        // Check if the queue is empty
    void clear();             // Remove all items from the queue
}

// ArrayQueue implemented as a class with an implicit reference to the queue instance
class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] queueArray;
    private int size;
    private int front;
    private int rear;

    // Constructor
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queueArray = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }

    // Enqueue an item to the queue
    @Override
    public void enqueue(T item) {
        if (size == queueArray.length) {
            // Handle resizing the array if necessary
            resizeArray();
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = item;
        size++;
    }

    // Get the first element in the queue
    @Override
    public T element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueArray[front];
    }

    // Dequeue and return the first item in the queue
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        size--;
        return item;
    }

    // Get the current queue size
    @Override
    public int size() {
        return size;
    }

    // Check if the queue is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Remove all items from the queue
    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    // Resize the underlying array if it reaches its capacity
    @SuppressWarnings("unchecked")
    private void resizeArray() {
        int newSize = queueArray.length * 2;
        T[] newArray = (T[]) new Object[newSize];
        int i = 0;
        while (!isEmpty()) {
            newArray[i++] = dequeue();
        }
        front = 0;
        rear = i - 1;
        size = i;
        queueArray = newArray;
    }
}

// Test class for the implemented ArrayQueue
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        // Testing enqueue and size
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("Queue size after enqueuing: " + queue.size());

        // Testing element and dequeue
        System.out.println("First element in the queue: " + queue.element());
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Queue size after dequeuing: " + queue.size());

        // Testing clear and isEmpty
        queue.clear();
        System.out.println("Is the queue empty after clearing? " + queue.isEmpty());
    }
}
