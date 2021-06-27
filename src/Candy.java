public class Candy {
//    public int candy(int[] ratings) {
//        for(int i = 0; i < ratings.length - 1; i++){
//            if(ratings[i] > ratings[i+1]){
//                ratings[i] = -1;
//            }
//            else if(ratings[i] < ratings[i+1]){
//                ratings[i] = 1;
//            }
//            else{
//                ratings[i] = 0;
//            }
//        }
//        ratings[ratings.length - 1] = 0;
//        int[] res = new int[ratings.length];
//        for(int i = -1; i < ratings.length - 1; i++){
//            if((i < 0 || ratings[i] == -1) && ratings[i+1] == 1){
//                res[i+1] = 1;
//                int left = i;
//                int right = i+2;
//                while(left >= 0 && ratings[left] <= 0){
//                    res[left] = res[left+1] + 1;
//                    if(ratings[left] == 0){
//                        break;
//                    }
//                    left--;
//                }
//                while(right < ratings.length && ratings[right] >= 0){
//                    res[right] = res[right-1] + 1;
//                    if(ratings[right] == 0){
//                        break;
//                    }
//                    right++;
//                }
//            }
//            else if(i >= 0 && ratings[i] == 0 && ratings[i+1] >= 0){
//                res[i+1] = 1;
//                int cur = i+2;
//                while(cur < ratings.length && ratings[cur] > 0){
//                    res[cur] = res[cur-1] + 1;
//                    cur++;
//                }
//            }
//            else if(i >= 0 && ratings[i] == 0 && ratings[i+1] <= 0){
//                res[i] = 1;
//                int cur = i-1;
//                while(cur >= 0 && ratings[cur] < 0){
//                    res[cur] = res[cur+1] + 1;
//                    cur--;
//                }
//            }
//        }
//        int sum = 0;
//        for(int i = 0; i < res.length; i++){
//            sum += res[i];
//        }
//        return sum;
//    }


    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int oldSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = (ratings[i] > ratings[i - 1]) ? 1
                    : (ratings[i] < ratings[i - 1] ? -1
                    : 0);

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }

    public static void main(String[] args){
        new Candy().candy(new int[]{1,3,2,2,1});
    }
}
