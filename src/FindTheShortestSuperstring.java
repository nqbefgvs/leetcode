import java.util.HashMap;
import java.util.Map;

public class FindTheShortestSuperstring {
    public String shortestSuperstring(String[] A) {
        //saved the checked string
        Map<String, String[]> map = new HashMap<>();
        int n = A.length;

        // DP State compression
        // 111111  each 1 is mean we had merged A[i]
        // 00001 is mean we had merged A[0]
        // 00101 is mean we had merged A[0] and A[2]
        String[] dp = new String[1 << n];
        for (int i = 0; i < n; i++) {
            dp[1 << i] = A[i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                //if we had merged A[j], skip it
                if ((i & (1 << j)) != 0) continue;

                //next is mean we merge j on state i
                //for example,  i = 01001,  j = 1
                //next = 01001 | (1 << 1) ==  01001 | 00010 = 01011
                int next = i | (1 << j);
                String[] e = getCommonString(map, dp[i], A[j]);
                if (dp[next] == null || e[1].length() < dp[next].length()) {
                    dp[next] = e[1];
                }
            }
        }
        return dp[dp.length - 1];
    }

    //find the common
    String[] getCommonString(Map<String, String[]> map, String a, String b) {
        String key = a + "#" + b;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        String[] common = check(a, b);
        String[] common2 = check(b, a);
        if (common2[0].length() > common[0].length()) {
            common = common2;
        }
        map.put(key, common);
        return common;
    }

    String[] check(String a, String b) {
        int res = 0;
        if (a.contains(b)) {
            return new String[]{b, a};
        }
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int n = arr2.length;
        //find the longest common string
        for (int i = n - 1; i >= 0; i--) {
            int l = n - i;
            if (l > arr1.length) break;
            boolean match = true;
            for (int j = 0; j < l; j++) {
                if (arr1[j] != arr2[i + j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                res = l;
            }
        }
        if (res == 0) return new String[]{"", a + b};
        String t = b + a.substring(res);
        return new String[]{a.substring(0, res), t};
    }
}
