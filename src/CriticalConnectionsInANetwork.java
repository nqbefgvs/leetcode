import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnectionsInANetwork {
    int[] disc;
    int[] low;
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer>[] adj;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)     {
        disc = new int[connections.size()];
        low = new int[connections.size()];
        adj = new List[connections.size()];
        for (List<Integer> conn : connections) { // build adjacency map
            if (adj[conn.get(0)] == null) adj[conn.get(0)] = new ArrayList();
            if (adj[conn.get(1)] == null) adj[conn.get(1)] = new ArrayList();
            adj[conn.get(0)].add(conn.get(1));
            adj[conn.get(1)].add(conn.get(0));
        }
        dfs(0, -1, 1);
        return ans;
    }

    private void dfs(int node, int parent, int time) {
        disc[node] = low[node] = time;
        for (Integer n : adj[node]) {
            if (n == parent)  continue; // skip parent node from which we came
            if (disc[n] == 0) { // unvisited
                dfs(n, node, ++time);
            }
            // node -> n is visited at this point, so update low
            low[node] = Math.min(low[node], low[n]);
            if (disc[node] < low[n]) { // neighbour is visited after the current node (no earlier path found)
                ans.add(Arrays.asList(node, n));
            }
        }
    }

    public static void main(String[] args){
        new CriticalConnectionsInANetwork().criticalConnections(6, new ArrayList(){{
            add(new ArrayList(){{add(0);add(1);}});
            add(new ArrayList(){{add(1);add(2);}});
            add(new ArrayList(){{add(2);add(0);}});
            add(new ArrayList(){{add(1);add(3);}});
            add(new ArrayList(){{add(3);add(4);}});
            add(new ArrayList(){{add(4);add(5);}});
            add(new ArrayList(){{add(5);add(3);}});}});
    }
}
