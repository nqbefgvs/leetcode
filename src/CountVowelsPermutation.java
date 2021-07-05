public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int[] a1 = new int[5];
        int[] a2 = new int[5];

        int res = 0;

        for(int i = 0; i < 5; i++){
            a1[i] = 1;
            a2[i] = 0;
        }

        while(--n > 0){
            a2[0] = ((a1[1] + a1[2]) % 1000000007 + a1[4]) % 1000000007;
            a2[1] = (a1[0] + a1[2]) % 1000000007;
            a2[2] = (a1[1] + a1[3]) % 1000000007;
            a2[3] = (a1[2]) % 1000000007;
            a2[4] = (a1[2] + a1[3]) % 1000000007;
            int[] temp = a1;
            a1 = a2;
            a2 = temp;
        }
        for(int a : a1){
            res = (res + a) % 1000000007;
        }
        return res;
    }
}
