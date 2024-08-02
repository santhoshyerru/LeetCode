class Solution {
    public int minSwaps(int[] nums) {
       int maxOnes = Arrays.stream(nums).sum();
       int n = nums.length;
       int l=0;
       int window_ones =0,  max_window_ones = 0;
       for(int r=0;r<2*n;r++){
            if(nums[r%n] ==1){
                window_ones+=1;
            }
            if(r-l+1 > maxOnes){
            
                window_ones -= nums[l%n];
                    l+=1;
            }
            max_window_ones = Math.max(window_ones, max_window_ones);
            
       }
       return maxOnes - max_window_ones;
    }
}