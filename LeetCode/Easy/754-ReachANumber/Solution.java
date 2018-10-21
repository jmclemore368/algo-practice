class Solution {
    public int reachNumber(int target) {
        /*
        See the following for the idea:
        https://leetcode.com/problems/reach-a-number/discuss/112968/Short-JAVA-Solution-with-Explanation
        */

        /*
        Going left or right is symmetric
        Only need to consider going right
                            0
                   -1             1
               -3      1       -1      3
             -6  0   -2  4    -4  2    0 6
        */
        target = Math.abs(target);

        // Advance to or just past target
        int step = 1;
        int sum = 0;
        while (sum < target) {
            sum += step;
            step++;
        }

        // Find the difference that we need to eliminate
        int diff = target - sum;

        // Hit the nail on the head
        if (diff == 0)
            return step - 1;

        // If diff is even, then there exists some step k where diff = k*2
        // such that we can reverse step to go left instead
        // which will eliminate this difference
        if (diff % 2 == 0)
            return step - 1;

        // Else, either the next step, or the following step
        // will produce an even difference
        int nextSum = sum + step;
        int nextDiff = target - nextSum;
        if ((nextDiff % 2 == 0)
            return step;
        else
            return step + 1;
    }

}
