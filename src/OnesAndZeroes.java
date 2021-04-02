public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] r = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++){
            int zero = 0;
            int one = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    zero++;
                }
                else{
                    one++;
                }
            }
            r[i][0] = zero;
            r[i][1] = one;
        }
//        return backTrack(r, 0, m, n);
        return dpMethod(r, m, n);
    }
//
//    int backTrack(int[][] r, int index, int m, int n){
//        if(index >= r.length){
//            return 0;
//        }
//        int left = backTrack(r, index+1, m, n);
//        int right = 0;
//        if(m >= r[index][0] && n >= r[index][1]){
//            right = backTrack(r, index+1, m-r[index][0], n-r[index][1]) + 1;
//        }
//        return left > right ? left : right;
//    }

    int dpMethod(int[][] r, int m, int n){
        int[][][] dp = new int[r.length+1][m+1][n+1];
        for(int i = 1; i <= r.length; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <=n; k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if(r[i-1][0] <= j && r[i-1][1] <=k){
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-r[i-1][0]][k-r[i-1][1]]+1);
                    }
                }
            }
        }
        return dp[r.length][m][n];
    }

    public static void main(String[] args){
        String[] strs = {"10","0001","111001","1","0"};
        OnesAndZeroes o = new OnesAndZeroes();
        System.out.println(o.findMaxForm(strs, 5, 3));
    }
}
