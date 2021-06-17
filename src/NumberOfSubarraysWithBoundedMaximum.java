import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfSubarraysWithBoundedMaximum {

//    public int numSubarrayBoundedMax(int[] nums, int left, int right){
//        int res = 0;
//        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
//        for(int num : nums){
//            if(num <= right){
//                heap.add(num);
//            }
//            else {
//                while(!heap.isEmpty()){
//                    if (heap.peek() >= left){
//                        res += heap.size();
//                    }
//                    heap.poll();
//                }
//            }
//        }
//        while(!heap.isEmpty()){
//            if (heap.peek() >= left){
//                res += heap.size();
//            }
//            heap.poll();
//        }
//        return res;
//    }

    public int numSubarrayBoundedMax(int[] arr, int L, int R)
    {
        int ans = 0;

        int i = 0;
        int prevValidCount = 0;

        for(int j = 0 ; j < arr.length ; j++)
        {
            if(arr[j] < L)
            {
                ans += prevValidCount;
            }
            else if(arr[j] > R)
            {
                i = j + 1;
                prevValidCount = 0;
            }
            else
            {
                ans += (j - i + 1);
                prevValidCount = (j - i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        new NumberOfSubarraysWithBoundedMaximum().numSubarrayBoundedMax(new int[]{73,55,36,5,55,14,9,7,72,52},32,69);
    }

}
