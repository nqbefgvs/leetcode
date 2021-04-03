import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] table = new int[s.length()];
        List<Pair<Integer, Integer>> quote = new ArrayList<>();
        for (int i = 0; i < table.length - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                quote.add(new Pair<>(i, i+1));
            }
        }
        int max = 0;
        for(Pair<Integer, Integer> q : quote){
            int left = q.getKey();
            int right = q.getValue();
            int count = 0;
            while(left >= 0 && right < s.length() && s.charAt(left) == '(' && s.charAt(right) == ')'){
                table[left] = table[right] = 1;
                left--;
                right++;
                count += 2;
                while(left >= 0 && table[left] == 1){
                    left--;
                    count++;
                }
                while(right < s.length() && table[right] == 1){
                    right++;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String args[]){
        LongestValidParentheses l = new LongestValidParentheses();
        String s = ")(((((()())()()))()(()))(";
        System.out.println(l.longestValidParentheses(s));
    }
}
