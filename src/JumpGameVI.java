import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class JumpGameVI {
//    public int maxResult(int[] nums, int k) {
//        int n = nums.length, res = nums[0];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
//        pq.add(new int[] { nums[0], 0 });
//        for(int i = 1; i < n; i++) {
//            while(pq.peek()[1] < i - k) pq.poll();
//            pq.add(new int[] { res = pq.peek()[0] + nums[i], i });
//        }
//        return res;
//    }

    public int maxResult(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[deque.peek()];
            if(i - k == deque.peek()) deque.poll();
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.add(i);
        }
        return nums[nums.length - 1];
    }
}
