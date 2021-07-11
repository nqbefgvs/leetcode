import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> lo;
    private PriorityQueue<Integer> hi;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        this.lo = new PriorityQueue<>((a, b) -> b - a); // max heap
        this.hi = new PriorityQueue<>((a, b) -> a - b); // min heap
    }

    public void addNum(int num) {
        if (lo.isEmpty() || lo.peek() >= num)
            lo.add(num);
        else
            hi.add(num);

        if (lo.size() > hi.size() + 1)
            hi.add(lo.poll());
        else if (hi.size() > lo.size())
            lo.add(hi.poll());
    }

    public double findMedian() {

        if (lo.size() == hi.size())
            return (lo.peek() + hi.peek()) * 0.5;

        return lo.peek() * 1.0;
    }
}
