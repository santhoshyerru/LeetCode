import java.util.*;
class Pair{
    int row; int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(char[][] image, int[][] visited){
        Queue<Pair> q = new LinkedList<>();
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(image[i][j]=='O'){
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
            int colN  = pair.col;
            for(int[] d: directions){
                int rowCur = rowN+d[0];
                int colCur = colN+d[1];
                if(rowCur>=0 && colCur>=0 && rowCur<image.length && colCur<image[0].length && image[rowCur][colCur]=='O' && visited[rowCur][colCur]!=1){
                    visited[rowCur][colCur] = 1;
                    q.offer(new Pair(rowCur, colCur));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && image[i][j]=='O'){
                    image[i][j] = 'X';
                }
            }
        }
    }
    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];
        bfs(board, vis);
    }
}