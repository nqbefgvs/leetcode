public class BinaryTreeCameras {
    int count = 0;
    public int minCameraCover(TreeNode root) {
        helper(root);
        return count;
    }

    int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        if(l == 0 || r == 0){
            if(l + r == 0){
                count++;
                return 1;//自己可上移
            }
            if(l + r == 1){
                return 2;//自己不可上移
            }
            if(l + r == 2){
                return 3;//自己不是监视器
            }
            if(l + r == 3){
                count++;
                return 1;
            }
        }
        if(l == 3 && r == 3){
            count++;
            return 1;
        }
        if(l == 1 || r == 1){
            count -= (l==1?1:0) + (r==1?1:0) - 1;
            return 2;
        }
        return 3;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode();
        root.left = new TreeNode();
        root.left.left = new TreeNode();
        root.left.right = new TreeNode();
        new BinaryTreeCameras().minCameraCover(root);
    }
}
