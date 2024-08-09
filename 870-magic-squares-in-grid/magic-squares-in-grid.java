class Solution {
    public int magic(int r, int c, int[][] grid){
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(hs.contains(grid[i][j]) || !(grid[i][j]>=1 && grid[i][j]<=9))
                return 0;
                hs.add(grid[i][j]);
            }
        }

        for(int i=r;i<r+3;i++){
            int sum = 0;
            for(int j=c;j<c+3;j++){
                sum += grid[i][j];
            }
            if(sum!=15)
            return 0;
        }
        for(int i=c ;i<c+3;i++){
            if(grid[r][i]+grid[r+1][i]+grid[r+2][i]!=15)
            return 0;
        }
        if(grid[r][c] +grid[r+1][c+1] +grid[r+2][c+2]!=15 || grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]!=15)
        return 0;

        return 1;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        int res = 0;
        for(int r=0;r<rows-2;r++ ){
            for(int c=0;c<cols-2;c++){
                res += magic(r, c, grid);
            }
        }
        return res;
        
    }
}