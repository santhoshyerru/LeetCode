class Pair{
    int row; int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int row, int col,int[][] image, int[][] visited, int newColor){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int color = image[row][col];
        image[row][col] = newColor;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int rowN = pair.row;
            int colN  = pair.col;
            for(int[] d: directions){
                int rowCur = rowN+d[0];
                int colCur = colN+d[1];
                if(rowCur>=0 && colCur>=0 && rowCur<image.length && colCur<image[0].length && image[rowCur][colCur]==color && visited[rowCur][colCur]!=1){
                    visited[rowCur][colCur] = 1;
                    q.offer(new Pair(rowCur, colCur));
                    image[rowCur][colCur] = newColor;
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] visited = new int[image.length][image[0].length];
    
                if(visited[sr][sc]!=1){
                    bfs(sr, sc, image, visited, newColor);
                }
           
        return image;
    }
}
