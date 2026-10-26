public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},1));
    }
    public static int search(int[] nums, int target) {
        if(nums.length==1){
            return nums[0]==target?0:-1;
        }
        int l=0,r= nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
//            left sorted
            else if (nums[l]<=nums[mid]) {
                if(target> nums[mid] || nums[l]>target){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
//            Right sorted
            else{
                if(target< nums[mid] || nums[r]<target){
                    r=mid-1;
                }
                else {
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}
