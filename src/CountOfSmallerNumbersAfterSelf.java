import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    private int M = 10000;

    class BIT {
        int[] tree;
        int offset, N;

        BIT(int lo, int hi) {
            N = hi - lo + 1;
            tree = new int[N + 1];
            offset = 1 - lo;
        }

        void inc(int x) {
            x += offset;
            for (; x <= N; x += x & -x) tree[x]++;
        }

        int get(int x) {
            x += offset;
            int res = 0;
            for (; x > 0; x -= x & -x) res += tree[x];
            return res;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        BIT ft = new BIT(-M, M);
        Integer[] res = new Integer[n];

        for (int i = n - 1; i >= 0; --i) {
            res[i] = ft.get(nums[i] - 1);
            ft.inc(nums[i]);
        }

        return Arrays.asList(res);
    }

    public static void main(String[] args){
        new CountOfSmallerNumbersAfterSelf().countSmaller(new int[]{5,2,6,1});
    }
}
