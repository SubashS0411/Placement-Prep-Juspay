import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1,2,3},2));
    }
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        int current=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            current += num;
            int old = current - k;
            if (map.containsKey(old)) {
                count += map.get(old);
            }
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return count;
    }
}
