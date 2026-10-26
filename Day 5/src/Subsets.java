import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>>ans =subsets(new int[]{1,2,3});
        System.out.println(ans);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        dfs(nums,0,subset,res);
        return res;
    }
    public static void dfs(int[] nums,int index,List<Integer> subset,List<List<Integer>> result){
        if(index>=nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums,index+1,subset,result);
        subset.remove(subset.size()-1);
        dfs(nums,index+1,subset,result);
    }
}
