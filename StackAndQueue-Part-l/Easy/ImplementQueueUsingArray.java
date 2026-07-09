// GFG Ques

class myQueue {

    LinkedList<Integer> q;
    int n;

    public myQueue(int n) {
        q = new LinkedList<>();
        this.n = n;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public boolean isFull() {
        return q.size() == n;
    }

    public void enqueue(int x) {
        if(isFull()) return;

        q.addLast(x);
    }

    public void dequeue() {
        if(isEmpty()) return;

        q.removeFirst();
    }

    public int getFront() {
        if(isEmpty()) return -1;

        return q.getFirst();
    }

    public int getRear() {
        if(isEmpty()) return -1;

        return q.getLast();
    }
}
