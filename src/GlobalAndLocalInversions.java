public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int count = 1;
        for(int i = 0; i < A.length; i++){
            if(A[i] >= first){
                second = first;
                first = A[i];
                count = 1;
            }
            else if(A[i] < first && A[i] >= second && count > 0){
                second = A[i];
                count = 0;
            }
            else{
                return false;
            }
        }
        return true;
    }

//    public boolean isIdealPermutation(int[] A) {
//        for(int i = 0; i < A.length; i++){
//            if(i+1 < A.length && A[i] > A[i+1]){
//                if((i-1 < 0 || i-1 >= 0 && A[i+1] > A[i-1]) && (i+2 >= A.length || i+2 < A.length && A[i+2] >A[i])){
//
//                }
//                else{
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
