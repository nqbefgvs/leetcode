import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        q.add(arr[0]);
//        for(int i = 1; i < arr.length; i++){
//            if(Math.abs(arr[i]-x) < Math.abs(q.peek()-x) || q.size() < k){
//                q.add(arr[i]);
//            }
//            if(q.size() > k){
//                q.poll();
//            }
//        }
//        List<Integer> res = new ArrayList();
//        while(!q.isEmpty()){
//            res.add(q.poll());
//        }
//        return res;
//    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;

        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
