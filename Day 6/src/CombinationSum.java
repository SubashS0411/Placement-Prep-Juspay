import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> ans=combinationSum(new int[]{2,3,6,7},7);
        System.out.println(ans);
        System.out.println(combinationSum(new int[]{2,3,5},8));
    }
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sum=new ArrayList<>();
        dfs(nums,target,sum,ans,0);
        return ans;
    }
    public static void dfs(int[] nums,int target,List<Integer> sum,List<List<Integer>> ans,int current){
        if(target==0){
            ans.add(new ArrayList<>(sum));
            return;
        }
        if(target<0 || current>= nums.length) {
            return;
        }
            sum.add(nums[current]);
            dfs(nums, target-nums[current], sum, ans, current);
            sum.remove(sum.size()-1);
            dfs(nums, target, sum, ans, current+1);
        }
    }

