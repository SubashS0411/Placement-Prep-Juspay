import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//        return set.size()!= nums.length;
//        or
//        for (int num:nums){
//            if(set.contains(num)) return true;
//            set.add(num);
//        }
//        return false;
//        or
        for (int num:nums){
            if(!set.add(num))return true;
        }
        return false;
    }
}
