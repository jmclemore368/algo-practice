class Solution {
    // Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int runMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runMax = Math.max(runMax + nums[i], nums[i]);
            currMax = Math.max(currMax, runMax);
        }
        return currMax;
    }
}
