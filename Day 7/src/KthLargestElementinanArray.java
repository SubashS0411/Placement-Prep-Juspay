import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2,3,1,5,4},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minheap.add(nums[i]);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        return minheap.peek();
    }
}
