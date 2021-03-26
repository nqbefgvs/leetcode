import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<Map<Character, Integer>> BList = new ArrayList();
        for(String b : B){
            BList.add(makeMap(b));
        }
        Map<Character, Integer> bMap = makeMap(BList);
        List<String> res = new ArrayList();
        for(String a : A){
            Map<Character, Integer> aMap = makeMap(a);
            if(contain(aMap, bMap)){
                res.add(a);
            }
        }
        return res;
    }

    Map<Character, Integer> makeMap(String str){
        Map<Character, Integer> strMap = new HashMap();
        for(int i = 0; i < str.length(); i++){
            if(strMap.get(str.charAt(i))!=null){
                strMap.put(str.charAt(i), strMap.get(str.charAt(i))+1);
            }
            else{
                strMap.put(str.charAt(i), 1);
            }
        }
        return strMap;
    }

    Map<Character, Integer> makeMap(List<Map<Character, Integer>> BList){
        Map<Character, Integer> bMap = new HashMap<>();
        for(Map<Character, Integer> B : BList){
            for(Map.Entry<Character, Integer> entry : B.entrySet()){
                if(bMap.get(entry.getKey()) == null || (Integer)bMap.get(entry.getKey()) < entry.getValue()){
                    bMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return bMap;
    }

    Boolean contain(Map a, Map<Character, Integer> bMap){
        for(Map.Entry<Character, Integer> entry : bMap.entrySet()){
            if(a.get(entry.getKey()) == null || (Integer)a.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"e","o"};
        WordSubsets wordSubsets = new WordSubsets();
        System.out.println(wordSubsets.wordSubsets(A, B));
    }
}
