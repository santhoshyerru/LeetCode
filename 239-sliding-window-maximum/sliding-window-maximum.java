class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> arrayQueue = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int ansIndex = 0;
        for(int i=0;i<nums.length;i++){
            while(!arrayQueue.isEmpty() && (i-k)>=arrayQueue.peekFirst()){
                arrayQueue.pollFirst();
            } 

            while(!arrayQueue.isEmpty() && nums[arrayQueue.peekLast()]<=nums[i]){
                arrayQueue.pollLast();
            }
            arrayQueue.offerLast(i);
            if(i>=(k-1))
            ans[ansIndex++] = nums[arrayQueue.peekFirst()];
        }
        return ans;
    }
}