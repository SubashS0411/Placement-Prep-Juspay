import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob1(new int[]{1,1,3,3}));
        System.out.println(rob2(new int[]{1,1,3,3}));
        System.out.println(rob3(new int[]{1,1,3,3}));
        System.out.println(rob4(new int[]{1,1,3,3}));
    }
//    Normal DFS
    public static int rob1(int[] nums) {
        return dfs(0,nums);
    }
    public static int dfs(int i,int[] nums){
        if(i>= nums.length){
            return 0;
        }
        return Math.max(dfs(i+1,nums),nums[i]+dfs(i+2,nums));
    }
//Memoization DFS
    static int[] memo;
    public static int rob2(int[] nums) {
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        return dfs1(0,nums);
    }
    public static int dfs1(int i,int[] nums){
        if(i>= nums.length){
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        memo[i]=Math.max(nums[i]+dfs(i+2,nums),dfs(i+1,nums));
        return memo[i];
    }

//    Tabulation
public static int rob3(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
    for (int i = 2; i < nums.length ; i++) {
        dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
    }
    return dp[nums.length-1];
}
//Space optimized
    public static int rob4(int[] nums) {
        int rob1=0,rob2=0;
        for(int num:nums){
            int temp=Math.max(rob1+num,rob2);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }
}
