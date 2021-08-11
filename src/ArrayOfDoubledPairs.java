import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < arr.length; i++){
            if(q.isEmpty()){
                q.add(arr[i]);
                continue;
            }
            if(arr[i] < 0 && q.peek() == 2 * arr[i]){
                q.poll();
            }
            else if(arr[i] < 0 && q.peek() != 2 * arr[i]){
                q.add(arr[i]);
            }
            else if(arr[i] >= 0 && 2 * q.peek() == arr[i]){
                q.poll();
            }
            else{
                q.add(arr[i]);
            }
        }
        if(q.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
