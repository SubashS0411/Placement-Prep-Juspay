import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        List<List<Integer>> res=pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        System.out.println(res);
    }
    static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows= heights.length,cols= heights[0].length;
        List<List<Integer>> res =new ArrayList<>();
        boolean[][] pac=new boolean[rows][cols];
        boolean[][] atl=new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            dfs(r,0,pac,heights,heights[r][0]);
            dfs(r,cols-1,atl,heights,heights[r][cols-1]);
        }
        for (int c = 0; c < cols; c++) {
            dfs(0,c,pac,heights,heights[0][c]);
            dfs(rows-1,c,atl,heights,heights[rows-1][c]);
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(pac[r][c]&&atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    public static void dfs(int row,int col,boolean[][] visited,int[][]heights,int height){
        if(row<0||col<0||row>=heights.length||col>=heights[0].length||visited[row][col]||heights[row][col]<height){
            return;
        }
        visited[row][col]=true;
        for(int[] dir:directions){
            dfs(row+dir[0], col+dir[1], visited, heights, heights[row][col]);
        }
    }

}
