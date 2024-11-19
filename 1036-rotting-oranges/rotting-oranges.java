class Pair{
    int row, col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {

    public int bfs(int[][] grid, int[][] visited){
  
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i, j));
                    visited[i][j]=1;
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int flag =0;
            for(int i =0;i<size;i++){
                Pair pair = q.poll();
                int rowN = pair.row;
                int colN = pair.col;

                for(int[] d: directions){
                    int rowCur = rowN+d[0];
                    int colCur = colN+d[1];
                    if(rowCur>=0 && colCur>=0 && rowCur<grid.length && colCur<grid[0].length && grid[rowCur][colCur]==1 && visited[rowCur][colCur]==0){
                        q.offer(new Pair(rowCur, colCur));
                        visited[rowCur][colCur] = 1;
                        grid[rowCur][colCur] = 2;
                        flag=1;
                    }
                }
            }
            if(flag==1)
            cnt++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if( grid[i][j]==1){
                    return -1;
                }
            }
        }
        return cnt;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        return bfs(grid, visited);

    }
}


