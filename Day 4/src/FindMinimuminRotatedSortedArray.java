public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin2(new int[]{3,4,5,6,0,1,2}));
    }
    public static int findMin(int[] nums) {
        if(nums.length==0||nums==null) return 0;
        int l=0,r= nums.length-1;
        while (l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]) {
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return nums[l];
    }
//    or
    public static int findMin2(int[] nums) {
        int l=0,r= nums.length-1;
        int ans=Integer.MAX_VALUE;
        while (l<r){
            int mid=l+(r-l)/2;
            if(nums[l]<=nums[mid]) {

                ans=Math.min(ans,nums[l]);
                l=mid+1;
            }
            else{
                r=mid-1;
                ans=Math.min(ans,nums[mid]);
            }
        }
        return ans;
    }

}
