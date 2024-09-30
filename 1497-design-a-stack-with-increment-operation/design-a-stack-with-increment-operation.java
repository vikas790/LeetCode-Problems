class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}

class CustomStack {
    int currSize, maxSize;
    Node head, tail;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.currSize = 0;
        
        // Initialize head and tail as dummy nodes
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    public void push(int x) {
        if (currSize < maxSize) {
            addAtHead(x);
            currSize++;
        }
    }

    public int pop() {
        if (currSize == 0)
            return -1;
        int x = head.next.val;
        removeAtHead();
        currSize--;
        return x;
    }

    public void increment(int k, int val) {
        k = Math.min(k, currSize);
        inc(k, val);
    }

    public void inc(int k, int val) {
        Node temp = tail.prev;
        while (k > 0) {
            temp.val += val;
            temp = temp.prev;
            k--;
        }
    }

    public void addAtHead(int val) {
        Node after = head.next;
        Node temp = new Node(val);
        head.next = temp;
        temp.prev = head;
        temp.next = after;
        after.prev = temp;
    }

    public void removeAtHead() {
        Node after = head.next.next; // Move to the next element
        head.next = after;
        after.prev = head;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */