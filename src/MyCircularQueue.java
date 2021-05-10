public class MyCircularQueue {

    int[] q;
    int front;
    int len;

    public MyCircularQueue(int k) {
        q = new int[k];
        front = 0;
        len = 0;
    }

    public boolean enQueue(int value) {
        if (len < q.length) {
            q[(front + len++) % q.length] = value;
            return true;
        } else return false;
    }

    public boolean deQueue() {
        if (len > 0) {
            front = (front + 1) % q.length;
            len--;
            return true;
        } else return false;
    }

    public int Front() {
        if (len > 0)
            return q[front];
        else return -1;
    }

    public int Rear() {
        if (len > 0)
            return q[(front + len - 1) % q.length];
        else return -1;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == q.length;
    }

    public static void main(String args[]) {
        MyCircularQueue m = new MyCircularQueue(3);
        m.enQueue(1);
        m.enQueue(2);
        m.enQueue(3);
        m.enQueue(4);
        System.out.println(m.Rear());
        m.deQueue();
        m.enQueue(4);
        System.out.println(m.Rear());
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */