import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> ans=permute(new int[]{1,2,3});
        System.out.println(ans);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> permutations=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        backtrack(nums,permutations,visited,ans);
        return ans;
    }
    public static void backtrack(int[] nums,List<Integer> permutations,boolean[] visited,List<List<Integer>> ans){
        if(permutations.size()== nums.length){
            ans.add(new ArrayList<>(permutations));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }
            visited[i]=true;
            permutations.add(nums[i]);
            backtrack(nums,permutations,visited,ans);
            visited[i]=false;
            permutations.remove(permutations.size()-1);
        }
    }
}


