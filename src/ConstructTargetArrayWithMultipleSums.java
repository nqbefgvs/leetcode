import java.util.Arrays;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] target) {
        Arrays.sort(target);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for(int i = 0; i < target.length; i++){
            heap.add(target[i]);
            sum += target[i];
        }
        while(sum > target.length){
            int biggest = heap.poll();
            heap.add(biggest - (sum - biggest));
            if(sum <= biggest){
                return false;
            }
            sum = biggest;
        }
        if(sum == target.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        new ConstructTargetArrayWithMultipleSums().isPossible(new int[]{9, 9, 9});
    }
}
