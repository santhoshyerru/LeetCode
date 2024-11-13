class Solution {
    public long lowerBound(int[] nums, int lower, int cur){
        int start = cur+1;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>=lower){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
    public long upperBound(int[] nums, int upper, int cur){
        int start = cur+1;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>upper){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        for(int i=0;i<nums.length;i++){
            result = result+ (upperBound(nums,upper-nums[i], i) - lowerBound(nums, lower-nums[i], i ));
        }
        return result;
      
    }
}