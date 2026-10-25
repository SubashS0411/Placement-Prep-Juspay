public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
    }
    public static int search(int[] nums, int target) {
        if(nums.length==1){
            return (nums[0]==target)?0:-1;
        }
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if (nums[mid]< target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}
