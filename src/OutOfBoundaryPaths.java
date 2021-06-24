public class OutOfBoundaryPaths {
    // class Node {
    //     int x;
    //     int y;
    //     Node(int x, int y){
    //         this.x = x;
    //         this.y = y;
    //     }
    // }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Queue<Node> queue = new LinkedList<>();
        // queue.add(new Node(startRow, startColumn));
        // int res = 0;
        // for(int i = 0; i < maxMove; i++){
        //     for(int loop_time = queue.size(); loop_time > 0; loop_time--){
        //         Node cur = queue.poll();
        //     if(cur.x > 0){
        //         queue.add(new Node(cur.x - 1, cur.y));
        //     }
        //     else{
        //         res++;
        //     }
        //     if(cur.x + 1 < m){
        //         queue.add(new Node(cur.x + 1, cur.y));
        //     }
        //     else{
        //         res++;
        //     }
        //     if(cur.y > 0){
        //         queue.add(new Node(cur.x, cur.y - 1));
        //     }
        //     else{
        //         res++;
        //     }
        //     if(cur.y + 1 < n){
        //         queue.add(new Node(cur.x, cur.y + 1));
        //     }
        //     else{
        //         res++;
        //     }
        //     }
        // }
        // return res;
        int res = 0;
        int[][] table1 = new int[m][n];
        int[][] table2 = new int[m][n];
        int[][] temptable;
        table1[startRow][startColumn] = 1;
        for(int i = 0; i < maxMove; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    if(j > 0){
                        table2[j-1][k] += table1[j][k];
                        table2[j-1][k] %= 1000000007;
                    }
                    else{
                        res = (res + table1[j][k]) % 1000000007;
                    }
                    if(j+1 < m){
                        table2[j+1][k] += table1[j][k];
                        table2[j+1][k] %= 1000000007;
                    }
                    else{
                        res = (res + table1[j][k]) % 1000000007;
                    }
                    if(k > 0){
                        table2[j][k-1] += table1[j][k];
                        table2[j][k-1] %= 1000000007;
                    }
                    else{
                        res = (res + table1[j][k]) % 1000000007;
                    }
                    if(k+1 < n){
                        table2[j][k+1] += table1[j][k];
                        table2[j][k+1] %= 1000000007;
                    }
                    else{
                        res = (res + table1[j][k]) % 1000000007;
                    }
                    table1[j][k] = 0;
                }
            }
            temptable = table2;
            table2 = table1;
            table1 = temptable;
        }
        return res;
    }
}
