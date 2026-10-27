public class DiameterofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        System.out.println(diameterOfBinaryTree(root));
    }
    static int diameter=0;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter=0;
        Calculatedfs(root);
        return diameter;
    }
    public static int Calculatedfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Calculatedfs(root.left);
        int right=Calculatedfs(root.right);
        diameter=Math.max(diameter,right+left);
        return 1+Math.max(right,left);
    }
}
