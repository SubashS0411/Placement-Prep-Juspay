import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }
//    memoization
    public static int climbStairs(int n) {
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return dfs(n,memo);
    }
    public static int dfs(int n,int[] memo){
        if(n<=2){
            return n;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        memo[n]=dfs(n-1,memo)+dfs(n-2,memo);
        return memo[n];
    }
//    Tabulation
    public static int climbStairs2(int n) {
        if(n<=2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
