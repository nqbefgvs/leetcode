import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Deque<Character> deque = new LinkedList();
        Deque<Integer> counter = new LinkedList();
        for(int i = 0; i < s.length(); i++){
            Integer cur = counter.isEmpty() ? 0 : counter.pop();
            Character c = s.charAt(i);
            if(deque.isEmpty() || c.equals(deque.peek())){
                counter.push(++cur);
            }
            else{
                counter.push(cur);
                counter.push(1);
            }
            deque.push(c);
            if(cur >= k){
                for(int j = 0; j < k; j++){
                    deque.pop();
                }
                counter.pop();
            }
        }
        String res = "";
        while(!deque.isEmpty()){
            res += deque.pollLast();
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new RemoveAllAdjacentDuplicatesInStringII().removeDuplicates("deeedbbcccbdaa", 3));
        String s = new String();
        s.substring(0);
    }
}
