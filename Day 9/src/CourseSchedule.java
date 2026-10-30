import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{0,1}}));
        System.out.println(canFinish(2,new int[][]{{0,1},{1,0}}));
    }
    public static Map<Integer, List<Integer>> map=new HashMap<>();
    public static Set<Integer> visiting=new HashSet<>();
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i,new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            map.get(pre[0]).add(pre[1]);
        }
        for (int c = 0; c < numCourses; c++) {
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }
    public static boolean dfs(int crs){
        if(visiting.contains(crs)) return false;
        if(map.get(crs).isEmpty()) return true;
        visiting.add(crs);
        for(int pre: map.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(crs);
        map.put(crs,new ArrayList<>());
        return true;
    }
}
