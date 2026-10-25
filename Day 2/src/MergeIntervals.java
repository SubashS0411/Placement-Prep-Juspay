import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][]ans=merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(ans));
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][];
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> list=new ArrayList<>();
        int[] prev=intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=prev[1]){
                prev[1]=Math.max(prev[1],intervals[i][1]);
            }else{
                list.add(prev);
                prev=intervals[i];
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}
