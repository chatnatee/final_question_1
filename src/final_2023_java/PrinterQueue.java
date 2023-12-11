package final_2023_java;

public class PrinterQueue {
    private PrintTask[] queue;
    private int front;
    private int rear;
    private int size;

    public PrinterQueue(int capacity) {
        queue = new PrintTask[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(PrintTask task) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue task.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = task;
        size++;
    }

    public PrintTask dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue task.");
            return null;
        }
        PrintTask task = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return task;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void clear() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }
}

class PrintTask {
    private String content;

    public PrintTask(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
