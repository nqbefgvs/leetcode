import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
//    public List<String> letterCombinations(String digits) {
//        List<Set<String>> ls = new ArrayList();
//        for(int i = 0; i < digits.length(); i++){
//            char c = digits.charAt(i);
//            Set<String> next = new HashSet<>();
//            if(!ls.isEmpty()){
//                Set<String> pre = ls.get(ls.size()-1);
//                for (String p : pre){
//                    next.add(p.concat(String.valueOf((char)((c - '2') * 3 + 'a'))));
//                    next.add(p.concat(String.valueOf((char)((c - '2') * 3 + 'b'))));
//                    next.add(p.concat(String.valueOf((char)((c - '2') * 3 + 'c'))));
//                }
//            }
//            else{
//                next.add(String.valueOf((char)((c - '2') * 3 + 'a')));
//                next.add(String.valueOf((char)((c - '2') * 3 + 'b')));
//                next.add(String.valueOf((char)((c - '2') * 3 + 'c')));
//            }
//            ls.add(next);
//        }
//        List<String> res = new ArrayList<>();
//        if(ls.isEmpty()){
//            return res;
//        }
//        for(String s : ls.get(ls.size()-1)){
//            res.add(s);
//        }
//        return res;
//    }
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = new HashMap<Character, String>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String args[]){
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        l.letterCombinations("234");
    }
}
