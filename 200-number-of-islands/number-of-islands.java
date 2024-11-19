class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(char[][] grid, int[][] vis, int row, int col){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            int rowN = cur.row;
            int colN = cur.col;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if((i==-1 && j==-1) || (i==1 && j==1) || (i==1 && j==-1) || (i==-1 && j==1))
                    continue;
                    int rowCur = rowN+i;
                    int colCur = colN+j;
                    if(rowCur>=0 && colCur>=0 && rowCur<grid.length && colCur<grid[0].length && grid[rowCur][colCur]=='1' && vis[rowCur][colCur]==0){
                        q.offer(new Pair(rowCur, colCur));
                        vis[rowCur][colCur]=1;
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int[][] vis = new int[n][m];
       int cnt = 0;
       for(int row = 0;row<n;row++){
        for(int col = 0;col<m;col++){
            if(grid[row][col]=='1' && vis[row][col]!=1){
                vis[row][col] = 1;
                bfs(grid, vis, row, col);
                cnt++;
            }
        }
       }
       return cnt;
    }
}

