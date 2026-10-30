public class NumberofProvinces {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
    public static int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] isvisited=new boolean[n];
        int res=0;
        for (int i = 0; i < n; i++) {
            if(!isvisited[i]){
                dfs(i,isConnected,isvisited,n);
                res++;
            }
        }
        return res;
    }
    public static void dfs(int node,int[][] isConnected,boolean[] visted,int n){
        visted[node]=true;
        for (int nei = 0; nei < n; nei++) {
            if(isConnected[node][nei]==1 && !visted[nei]){
                dfs(nei,isConnected,visted,n);
            }
        }
    }
}
