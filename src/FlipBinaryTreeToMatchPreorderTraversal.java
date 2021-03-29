import java.util.ArrayList;
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
public class FlipBinaryTreeToMatchPreorderTraversal {
    int[] voyage;
    int index = 0;
    List<Integer> res = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        checkNode(root);
        for(Integer i : res){
            if(i == -1){
                res = new ArrayList<>();
                res.add(-1);
                return res;
            }
        }
        return res;
    }

    void checkNode(TreeNode node){
        if(node.val != voyage[index]){
            res.add(-1);
            return;
        }
        if(node.left != null){
            if(node.left.val == voyage[index+1]){

            }
            else if(node.right != null && node.right.val == voyage[index+1]){
                swapChild(node);
            }
            else{
                res.add(-1);
                return;
            }
            index++;
            checkNode(node.left);
        }
        if(node.right != null){
            if(node.right.val == voyage[index+1]){
                index++;
                checkNode(node.right);
            }
            else{
                res.add(-1);
                return;
            }
        }
    }

    void swapChild(TreeNode parent){
        res.add(parent.val);
        TreeNode temp = parent.left;
        parent.left = parent.right;
        parent.right = temp;
    }

    public static void main(String args[]){
        int[] voyage = {1, 3, 2};
        TreeNode a = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), null);
        FlipBinaryTreeToMatchPreorderTraversal flipBinaryTreeToMatchPreorderTraversal = new FlipBinaryTreeToMatchPreorderTraversal();
        System.out.println(flipBinaryTreeToMatchPreorderTraversal.flipMatchVoyage(a, voyage));
    }
}
