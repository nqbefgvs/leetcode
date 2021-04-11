import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> level1 = new ArrayList<>();
        List<TreeNode> level2 = new ArrayList<>();
        level2.add(root);
        while(!level2.isEmpty()){
            level1 = level2;
            level2 = new ArrayList<>();
            for(TreeNode t : level1){
                if(t.left!=null)
                    level2.add(t.left);
                if(t.right!=null)
                    level2.add(t.right);
            }
        }
        int res = 0;
        for(TreeNode t : level1){
            res += t.val;
        }
        return res;
    }
}
