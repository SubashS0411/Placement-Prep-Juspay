public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.right = new TreeNode(3, new TreeNode(1), new TreeNode(-9));
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        return Valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean Valid(TreeNode root,long left,long right){
        if(root==null){
            return true;
        }
        if(!(left<root.val && root.val<right)){
            return false;
        }
        return Valid(root.left,left,root.val) && Valid(root.right,root.val,right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}