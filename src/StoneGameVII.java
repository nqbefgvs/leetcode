import java.util.Arrays;

public class StoneGameVII {
    int dp[][];
    int help(int arr[],int start,int end,int total){
        if(start>end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];


        return dp[start][end]= Math.max(total-arr[start]-help(arr,start+1,end,total-arr[start]),total-arr[end]-help(arr,start,end-1,total-arr[end]));
    }
    public int stoneGameVII(int[] stones) {
        dp=new int[stones.length][stones.length];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int sum=0;
        for(int i:stones){
            sum+=i;
        }
        return help(stones,0,stones.length-1,sum);
    }

    public static void main(String[] args){
        new StoneGameVII().stoneGameVII(new int[]{7,90,5,1,100,10,10,2});
    }
}
