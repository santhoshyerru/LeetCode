class Solution {
  public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;

        while (r < nums.length) {
            sum += nums[r];

            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return (double) maxSum / k;
    }
}
     
