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

        TreeNode head = new TreeNode(nums[mid]);

        // if nums.length == 2, returns arr of element at nums[0]
        head.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));

        // if nums.length == 2, mid is rightmost element
        head.right = (mid == nums.length - 1) ? null : sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return head;
    }
}
