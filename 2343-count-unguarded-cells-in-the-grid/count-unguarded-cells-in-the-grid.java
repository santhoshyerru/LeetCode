class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] gw = new int[m][n];
        for(int[] guard: guards){
            gw[guard[0]][guard[1]] = 2;
        }
        for(int[] wall: walls){
            gw[wall[0]][wall[1]] = 2;
        }

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for(int[] guard: guards){
           
            for(int[] d: directions){
                 int x = guard[0];
            int y = guard[1];
                while(x+d[0]>=0 && x+d[0]<m && y+d[1]>=0 && y+d[1]<n && gw[x+d[0]][y+d[1]]<2){
                    x+=d[0];
                    y+=d[1];
                    gw[x][y] = 1;
                }
            }
        }
        int uncount = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(gw[i][j] ==0){
                    uncount++;
                }
            }
        }
        return uncount;
    }
}