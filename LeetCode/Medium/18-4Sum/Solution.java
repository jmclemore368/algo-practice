class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int start, int target, int k) {
        // Base case is 2-sum
        if (k <= 2) {
            List<List<Integer>> twoSum = new LinkedList<>();
            int j = start;
            int n = nums.length - 1;
            while (j < n) {
                if (nums[j] + nums[n] == target) {
                    twoSum.add(new LinkedList<>(Arrays.asList(nums[j], nums[n])));
                    j+=1;
                    n-=1;
                    while (j < n && nums[j] == nums[j - 1]) j++;
                    while (j < n && nums[n] == nums[n + 1]) n--;
                } else if (nums[j] + nums[n] < target) {
                    j++;
                } else {
                    n--;
                }
            }
            return twoSum;
        }

        List<List<Integer>> res = new LinkedList<>();
        for (int i = start; i < nums.length - k + 1; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            List<List<Integer>> kMinusOneSum =  kSum(nums, i + 1, target - nums[i], k - 1);
            for (List<Integer> list : kMinusOneSum) {
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
