class Solution {
  
    public int findLongestChain(int[][] pairs) {
       Arrays.sort(pairs, (pair1, pair2) -> pair1[1] - pair2[1]);
       int limit = pairs[0][1];
       int count = 1;
       for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>limit){
                count++;
                limit = pairs[i][1];
            }
       }
       return count;
    }
}