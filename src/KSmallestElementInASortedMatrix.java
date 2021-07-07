public class KSmallestElementInASortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while(start < end) {
            int mid = start + (end - start) / 2;
            int[] countRange = { matrix[0][0], matrix[n - 1][n - 1] };
            int count = countLessEqual(matrix, mid, countRange);
            if(count == k) {
                return countRange[0];
            }
            if(count < k) {
                start = countRange[1];
            }
            else {
                end = countRange[0];
            }
        }
        return start;
    }
    private static int countLessEqual(int[][] matrix, int mid, int[] countRange) {
        int count = 0;
        int n = matrix.length, row = 0, col = n - 1;
        while(col >= 0 && row < n) {
            if(matrix[row][col] > mid) {
                countRange[1] = Math.min(countRange[1], matrix[row][col]);
                col--;
            }
            else {
                countRange[0] = Math.max(countRange[0], matrix[row][col]);
                count += col + 1;
                row++;
            }
        }
        return count;
    }
}
