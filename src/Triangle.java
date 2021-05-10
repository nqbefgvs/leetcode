import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (i != 0) {
                    dp[i][j] += j == 0 ? dp[i - 1][j] : Math.min(dp[i - 1][j - 1], j < triangle.get(i).size() - 1 ? dp[i - 1][j] : dp[i - 1][j - 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            res = Math.min(res, dp[triangle.size() - 1][i]);
        }
        return res;
    }
}
