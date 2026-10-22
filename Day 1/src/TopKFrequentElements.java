import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,2,3,3,3},2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> min=new PriorityQueue<>(
                (a,b)->map.get(a)- map.get(b)
        );
        for (int key: map.keySet()) {
            min.add(key);
            if(min.size()>k){
                min.poll();
            }
        }
        int[] ans =new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=min.poll();
        }
//        System.gc();
        return ans;
    }
}
