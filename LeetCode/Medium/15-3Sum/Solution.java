class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        // Sort so we can avoid duplicates when we run 2-sum
        Arrays.sort(nums);

        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) // skip duplicate i
                continue;

            // Find all distinct 2-sums in the subarray
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j += 1;
                    k -= 1;
                    while (j < k && nums[j] == nums[j - 1]) j++; // skip duplicate j
                    while (j < k && nums[k] == nums[k + 1]) k--; // skip duplicate k
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}
