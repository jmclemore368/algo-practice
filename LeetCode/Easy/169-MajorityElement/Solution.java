class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int count = 0;
        Integer elem = null;
        for (int num : nums) {
            if (count == 0)
                elem = num;
            count += (num == elem) ? 1 : -1;
        }
        return elem;
    }
}
