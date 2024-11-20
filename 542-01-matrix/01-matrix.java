class Pair{
    int row, col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;

    }
}
class Solution {
    public void bfs(int[][] grid, int[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] distance = {{0,-1}, {0, 1}, {1, 0}, {-1, 0}};
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new Pair(i,j));
                    grid[i][j] =0;
                    vis[i][j] = 1;
                }
            }
        }
        int dis = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair pair = q.poll();
                int row = pair.row;
                int col = pair.col;
                for(int[] d: distance){
                    int rowN = row+d[0];
                    int colN = col+d[1];
                    if(rowN>=0 && colN>=0 && rowN<n && colN<m && vis[rowN][colN]==0){
                        q.offer(new Pair(rowN, colN));
                        grid[rowN][colN] = dis;
                        vis[rowN][colN] =1;
                    }
                }
            }
            dis++;
        }
    }
    public int[][] updateMatrix(int[][] grid) {
         int[][] vis = new int[grid.length][grid[0].length];
       bfs(grid, vis);
       return grid;
    }
}