class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int count = 0, maxLen = 0;
        for(int i=0;i<nums.length;i++){
            count = count + (nums[i]==1?1:-1);
            if(hm.containsKey(count)){
                maxLen = Math.max(maxLen, i-hm.get(count));
            }
            else{
                hm.put(count, i);
            }
        }
        return maxLen;
    }
}