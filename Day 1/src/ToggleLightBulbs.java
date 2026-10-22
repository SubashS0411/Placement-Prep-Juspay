import java.util.*;

public class ToggleLightBulbs {
    public static void main(String[] args) {
        System.out.println(toggleLightBulbs(Arrays.asList(10, 30, 20, 10)));
    }
    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
//        Set<Integer> ans=new TreeSet<>();
//        for (int n:bulbs){
//            if(ans.contains(n)){
//                ans.remove(Integer.ValueOf(n));
//            }
//            else ans.add(n);
//        }
//        return new ArrayList<>(ans);
        HashSet<Integer> set=new HashSet<>();
        for(int n:bulbs){
            if(!set.remove(n)){
                set.add(n);
            }
        }
        List<Integer> ans=new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
