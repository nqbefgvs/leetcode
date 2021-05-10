import java.util.*;

public class ReconstructOriginalDigitsFromEnglish {
//    public String originalDigits(String s) {
//        String[] letters = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        List<Map> l = new ArrayList<>();
//        for (String letter : letters){
//            l.add(makeMap(letter));
//        }
//        Map<Character, Integer> sMap = makeMap(s);
//        List<Integer> integerList = new ArrayList<Integer>();
//        while(!sMap.isEmpty()){
//            for(int i = 0; i < l.size(); i++){
//                Map<Character, Integer> letterMap = l.get(i);
//                Boolean flag = true;
//                for(Map.Entry<Character, Integer> entry : letterMap.entrySet()){
//                    if(sMap.get(entry.getKey()) == null || (Integer)entry.getValue() > sMap.get(entry.getKey())){
//                        flag = false;
//                    }
//                }
//                if(flag){
//                    for(Map.Entry<Character, Integer> entry : letterMap.entrySet()){
//
//                        sMap.put(entry.getKey(), sMap.get(entry.getKey()) - entry.getValue());
//                        if(sMap.get(entry.getKey()) == 0){
//                            sMap.remove(entry.getKey());
//                        }
//                    }
//                    integerList.add(l.indexOf(letterMap));
//                    i--;
//                }
//            }
//        }
//        String res = new String();
//        Collections.sort(integerList);
//        for(Integer integer : integerList){
//            res += integer.toString();
//        }
//        return res;
//    }
//
//    Map<Character, Integer> makeMap(String str){
//        Map<Character, Integer> res = new HashMap<Character, Integer>();
//        for(int i = 0; i < str.length(); i++){
//            res.put(str.charAt(i), res.get(str.charAt(i))==null?1:res.get(str.charAt(i))+1);
//        }
//        return res;
//    }

    public String originalDigits(String s) {
        String[] letters = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int zCount = count['z' - 'a'];
        while (zCount > 0) {
            for (int i = 0; i < letters[0].length(); i++) {
                count[letters[0].charAt(i) - 'a']--;
            }
            zCount--;
            res.add(0);
        }
        int gCount = count['g' - 'a'];
        while (gCount > 0) {
            for (int i = 0; i < letters[8].length(); i++) {
                count[letters[8].charAt(i) - 'a']--;
            }
            gCount--;
            res.add(8);
        }
        int wCount = count['w' - 'a'];
        while (wCount > 0) {
            for (int i = 0; i < letters[2].length(); i++) {
                count[letters[2].charAt(i) - 'a']--;
            }
            wCount--;
            res.add(2);
        }
        int xCount = count['x' - 'a'];
        while (xCount > 0) {
            for (int i = 0; i < letters[6].length(); i++) {
                count[letters[6].charAt(i) - 'a']--;
            }
            xCount--;
            res.add(6);
        }
        int hCount = count['h' - 'a'];
        while (hCount > 0) {
            for (int i = 0; i < letters[3].length(); i++) {
                count[letters[3].charAt(i) - 'a']--;
            }
            hCount--;
            res.add(3);
        }
        int uCount = count['u' - 'a'];
        while (uCount > 0) {
            for (int i = 0; i < letters[4].length(); i++) {
                count[letters[4].charAt(i) - 'a']--;
            }
            uCount--;
            res.add(4);
        }
        int fCount = count['f' - 'a'];
        while (fCount > 0) {
            for (int i = 0; i < letters[5].length(); i++) {
                count[letters[5].charAt(i) - 'a']--;
            }
            fCount--;
            res.add(5);
        }
        int vCount = count['v' - 'a'];
        while (vCount > 0) {
            for (int i = 0; i < letters[7].length(); i++) {
                count[letters[7].charAt(i) - 'a']--;
            }
            vCount--;
            res.add(7);
        }
        int iCount = count['i' - 'a'];
        while (iCount > 0) {
            for (int i = 0; i < letters[9].length(); i++) {
                count[letters[9].charAt(i) - 'a']--;
            }
            iCount--;
            res.add(9);
        }
        int oCount = count['o' - 'a'];
        while (oCount > 0) {
            for (int i = 0; i < letters[1].length(); i++) {
                count[letters[1].charAt(i) - 'a']--;
            }
            oCount--;
            res.add(1);
        }
        Collections.sort(res);
        String r = new String();
        for (Integer integer : res) {
            r += integer;
        }
        return r;
    }

    public static void main(String args[]) {
        ReconstructOriginalDigitsFromEnglish reconstructOriginalDigitsFromEnglish = new ReconstructOriginalDigitsFromEnglish();
        System.out.println(reconstructOriginalDigitsFromEnglish.originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
}
