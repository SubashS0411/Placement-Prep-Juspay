import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestIntegerinBST {
    public static void main(String[] args) {

    }
//    arr+DFS
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> arr=new ArrayList<>();
        dfs(root,arr);
        return arr.get(k-1);
    }
    public static void dfs(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        dfs(root.left,arr);
        arr.add(root.val);
        dfs(root.right,arr);
    }

//    STACK+DFS
public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while (!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();
            k--;
            if(k==0){
                return current.val;
            }
            current=current.right;
        }
        return -1;
}
}
