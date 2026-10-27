import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        System.out.println("--- Original Tree (Level Order) ---");
        System.out.println("\n--- Inverted Tree (Level Order) ---");
        List<List<Integer>> result=levelOrder2(root);
        System.out.println(result);

//        printLevelOrder(root);

    }
//BFS
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        if(root==null){
            return ans;
        }
        current.add(root);
        while (!current.isEmpty()) {
            int level = current.size();
            List<Integer> clevel = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = current.poll();
                clevel.add(node.val);
                if (node.left != null) {
                    current.add(node.left);
                }
                if (node.right != null) {
                    current.add(node.right);
                }

            }
            ans.add(clevel);
        }
        return ans;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            System.out.println();
        }
    }
    //DFS
    static List<List<Integer>> ans=new ArrayList<>();
    public static List<List<Integer>> levelOrder2(TreeNode root) {

        dfs1(root,0);
        return ans;
    }
    public static void dfs1(TreeNode root,int depth){
        if(root==null) return;
        if(ans.size()==depth){
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(root.val);
        dfs1(root.left,depth+1);
        dfs1(root.right,depth+1);
    }
}
