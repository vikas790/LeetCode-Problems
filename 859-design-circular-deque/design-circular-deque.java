class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;

    // Constructor to initialize deque with size k.
    public MyCircularDeque(int k) {
        deque = new int[k];
        front = -1;
        rear = -1;
        size = k;
    }

    // Insert element at the front. Return true if successful.
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + size) % size;
        }
        deque[front] = value;
        return true;
    }

    // Insert element at the rear. Return true if successful.
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        deque[rear] = value;
        return true;
    }

    // Delete element from the front. Return true if successful.
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (front == rear) {
            front = rear = -1;  // Reset to empty state
        } else {
            front = (front + 1) % size;
        }
        return true;
    }

    // Delete element from the rear. Return true if successful.
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (front == rear) {
            front = rear = -1;  // Reset to empty state
        } else {
            rear = (rear - 1 + size) % size;
        }
        return true;
    }

    // Get the front item. Return -1 if the deque is empty.
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    // Get the last item. Return -1 if the deque is empty.
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }

    // Check if deque is empty.
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if deque is full.
    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */