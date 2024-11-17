class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int i = 0,  j = 0, p=0, count=1;
        while(j<nums.length){
            if(j>0 && nums[j]==nums[j-1]+1){
                count++;
            }
            if(j-i+1>k){
                if(nums[i+1]==nums[i]+1){
                    count--;
                }
                i++;
            }
            if(j-i+1==k){
                if(count==k){
                    res[p++] = nums[j];
                }else{
                    res[p++] = -1;
                }
            }

            j++;
        }
        return res;
    }
}