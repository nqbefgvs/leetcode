public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
//                if(i == 0 && j == 0){
//                    // do nothing
//                }
//                else if(i == 0){
//                    matrix[i][j] += matrix[i][j-1];
//                }
//                else if(j == 0){
//                    matrix[i][j] += matrix[i-1][j];
//                }
//                else{
//                    matrix[i][j] += matrix[i][j-1] + matrix[i-1][j] - matrix[i-1][j-1];
//                }
                matrix[i][j] += (i==0?0:matrix[i-1][j]) + (j==0?0:matrix[i][j-1]) - (i==0||j==0?0:matrix[i-1][j-1]);
                for(int m = -1; m < i; m++){
                    for(int n = -1; n < j; n++){
                        if(matrix[i][j] - (m==-1?0:matrix[m][j]) - (n==-1?0:matrix[i][n]) + (m==-1||n==-1?0:matrix[m][n]) == target){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new NumberOfSubmatricesThatSumToTarget().numSubmatrixSumTarget(new int[][]{{0, 1, 0},{1, 1, 1},{0, 1, 0}}, 0));
    }
}
