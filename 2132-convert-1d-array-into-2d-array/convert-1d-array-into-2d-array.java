class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)
        return new int[0][0];
        int i=0, j=0, k=0;
        int[][] res = new int[m][n];
        while(i<original.length){
            res[k][j] = original[i];
            i++;
            j++;
            if(j==n){
                k++;
                j=0;
            }
        }
        return res;
    }
}