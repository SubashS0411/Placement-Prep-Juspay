import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{2,20,4,10,3,4,5}));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int count=1;
        int high=1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if(nums[i-1]+1==nums[i]) {
                count++;
                high=Math.max(count,high);
            }
            else count=1;
        }
        return high;
    }
}
