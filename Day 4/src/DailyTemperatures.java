import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int pre=st.pop();
                ans[pre]=i-pre;
            }
            st.push(i);
        }
        return ans;
    }
}
