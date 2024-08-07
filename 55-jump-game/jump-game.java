class Solution {
    public boolean canJump(int[] nums) {
        int max_index = 0;
        for(int i=0;i<nums.length;i++){
            if(max_index<i) return false;
            if(i+nums[i]>max_index) max_index=i+nums[i];
            if(max_index>=nums.length-1)
            return true;
        }
        return false;
    }
}