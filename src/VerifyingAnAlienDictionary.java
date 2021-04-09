public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length - 1; i++){
            String cur = words[i];
            String next = words[i+1];
            for(int j = 0; j <= cur.length() && j <= next.length(); j++){
                if(j == next.length() && j < cur.length()){
                    return false;
                }
                else if(j == cur.length()){
                    break;
                }
                int l = order.indexOf(cur.charAt(j));
                int r = order.indexOf(next.charAt(j));
                if(l > r){
                    return false;
                }
                else if(l < r){
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        VerifyingAnAlienDictionary v = new VerifyingAnAlienDictionary();
        System.out.println(v.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
