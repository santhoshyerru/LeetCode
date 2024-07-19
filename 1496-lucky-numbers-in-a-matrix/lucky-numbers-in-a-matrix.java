class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int maximumOfMinimumsRow = 0;
        for(int[] row: matrix){
            int rowMin = Arrays.stream(row).min().getAsInt();
            maximumOfMinimumsRow = Math.max(rowMin, maximumOfMinimumsRow);
        }

        int minimumOfMaximums = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            int colMin = 0;
            for(int j=0;j<matrix.length;j++){
               colMin = Math.max(colMin,matrix[j][i]);
            }
            minimumOfMaximums = Math.min(colMin, minimumOfMaximums);
        }

        return minimumOfMaximums == maximumOfMinimumsRow ? Collections.singletonList(maximumOfMinimumsRow) : Collections.emptyList();
    }
}