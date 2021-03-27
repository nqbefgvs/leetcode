public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            int j = 0;
            while(i+j < s.length() && i-j >= 0 && s.charAt(i+j) == s.charAt(i-j)){
                count++;
                j++;
            }
            j = 0;
            while(i+j+1 < s.length() && i-j >= 0 && s.charAt(i+j+1) == s.charAt(i-j)){
                count++;
                j++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }
}
