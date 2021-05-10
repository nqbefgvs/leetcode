public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int count = n;
        while (--k > 0) {
            res[n - 1 - k--] = count--;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (res[i] == 0) {
                res[i] = count--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new BeautifulArrangementII().constructArray(3, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
