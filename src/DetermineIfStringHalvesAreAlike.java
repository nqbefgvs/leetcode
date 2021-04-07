public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int lc = 0, rc = 0;
        for(int left = 0, right = s.length()/2;right < s.length(); left++, right++){
            if(isVowel(s.charAt(left))){
                lc++;
            }
            if(isVowel(s.charAt(right))){
                rc++;
            }
        }
        if(lc == rc){
            return true;
        }
        return false;
    }

    boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}
