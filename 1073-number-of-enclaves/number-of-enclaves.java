class Pair{
    int row, col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
    
}
class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                    q.offer(new Pair(i, j));
                    visited[i][j] = 1;
                    }
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int rowN = pair.row;
            int colN = pair.col;
            visited[rowN][colN] = 1;
            for(int[] d:directions){
                int rowCur = rowN+d[0];
                int colCur = colN+d[1];
                if(rowCur>=0 && colCur>=0 && rowCur<n && colCur<m && grid[rowCur][colCur]==1 && visited[rowCur][colCur]!=1){
                    visited[rowCur][colCur] = 1;
                    q.offer(new Pair(rowCur, colCur));
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt; 
    }
}