import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {

    }
//    BFS
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode right=null;
            int currentsize = queue.size();
            for (int i = 0; i < currentsize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode != null) {
                    right = currentNode;
                    queue.offer(currentNode.left);
                    queue.offer(currentNode.right);
                }
            }

                if (right != null) {
                    res.add(right.val);
                }
        }
        return res;
    }
//    DFS
    static List<Integer> result=new ArrayList<>();
    public static List<Integer> rightSideView2(TreeNode root) {
        dfs(root,0);
        return result;
    }
    public static void dfs(TreeNode root,int depth){
        if(root==null) return;
        if(result.size()==depth){
            result.add(root.val);
        }
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);

    }
}
