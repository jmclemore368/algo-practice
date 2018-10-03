/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        if (nums.length == 1)
            return new TreeNode(nums[0]);

        int mid = nums.length / 2;

        // Mid will either be the middle element in an odd length array
        // or the rightmost element. So we need to check. Left will always be ok in range.
        TreeNode head = new TreeNode(nums[mid]);
        head.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        head.right = (mid == nums.length - 1) ? null : sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return head;
    }
}
