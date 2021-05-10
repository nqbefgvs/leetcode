public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int res = 0;
        int count0 = 0, count1 = 0;
        int turn = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                if (turn == 1) {
                    count1++;
                } else {
                    turn = 1;
                    count1 = 1;
                }
                if (count1 <= count0) {
                    res++;
                }
            } else if (c == '0') {
                if (turn == 0) {
                    count0++;
                } else {
                    turn = 0;
                    count0 = 1;
                }
                if (count0 <= count1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new CountBinarySubstrings().countBinarySubstrings("00110");
    }

}
