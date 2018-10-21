class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hm.containsKey(complement))
                return new int[]{i, hm.get(complement)};
            hm.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }
}
