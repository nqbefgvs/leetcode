import java.util.HashMap;
import java.util.Map;

class MapSumPairs {

    Map originMap = new HashMap();
    Map prefixMap = new HashMap();
    /** Initialize your data structure here. */
    public MapSumPairs() {

    }

    public void insert(String key, int val) {
        int recentVal;
        if(originMap.containsKey(key)){
            recentVal = (int) originMap.get(key);
        }
        else{
            recentVal = 0;
        }
        originMap.put(key, val);
        for(int i = key.length(); i > 0; i--){
            prefixMap.put(key.substring(0, i), (int) prefixMap.getOrDefault(key.substring(0, i), 0) - recentVal + val);
        }
    }

    public int sum(String prefix) {
        return (int) prefixMap.getOrDefault(prefix, 0);
    }

    public static void main(String[] args){
        MapSumPairs mapSumPairs = new MapSumPairs();
        mapSumPairs.insert("apple", 3);
        mapSumPairs.sum("ap");
        mapSumPairs.insert("app", 2);
        mapSumPairs.sum("ap");
    }
}