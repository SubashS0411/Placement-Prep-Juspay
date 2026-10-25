import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        List<List<Integer>> ans=threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(ans);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1,right= nums.length-1;
            while (left<right){
                int threesum=nums[i]+nums[left]+nums[right];
                if(threesum<0) left++;
                else if(threesum>0) right--;
                else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(nums[left]== nums[left-1] && left<right){
                        left++;
                    }
                    while (nums[right] ==nums[right+1] && left<right){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
