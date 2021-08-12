import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String[] sortedStr = new String[strs.length];
        int n = strs.length;
        for(int i = 0; i < n; i++){
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            sortedStr[i] = String.valueOf(cs);
        }
        for(int i = 0; i < n; i++){
            String s = sortedStr[i];
            if(!map.containsKey(s)){
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(strs[i]);
                map.put(s, arrayList);
            } else {
               map.get(s).add(strs[i]);
            }
        }
        for(Map.Entry<String, ArrayList<String>> elem : map.entrySet()){
            res.add(elem.getValue());
        }
        return res;
    }
}
