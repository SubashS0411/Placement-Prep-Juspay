import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{1,1,0},{0,1,1},{0,1,2}}));
    }
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int row=grid.length,col= grid[0].length;
        int time=0,fresh=0;
        for (int r = 0; r<row ; r++) {
            for (int c = 0; c < col; c++) {
                if(grid[r][c]==1){
                    fresh++;
                }
                if(grid[r][c]==2){
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty() && fresh>0){
            int length=q.size();
            for (int i = 0; i <length ; i++) {
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int[] dir:directions){
                    int row1=r+dir[0];
                    int col1=c+dir[1];
                    if(row1<0 || col1<0 || row1>=grid.length || col1>= grid[0].length || grid[row1][col1]!=1){
                        continue;
                    }
                    grid[row1][col1]=2;
                    q.offer(new int[]{row1,col1});
                    fresh--;
                }
            }
            time++;
        }
        return fresh==0?time:-1;

    }
}
