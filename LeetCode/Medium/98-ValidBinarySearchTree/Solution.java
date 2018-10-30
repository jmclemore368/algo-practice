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
    public boolean isValidBST(TreeNode root) {
        List<Integer> ll = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        // Inorder traversal gives tree in non-decreasing order
        TreeNode curr = root;
        stack.addFirst(curr);
        while(!stack.isEmpty()) {
            while (curr != null) {
                stack.addFirst(curr.left);
                curr = stack.peekFirst();
            }
            curr = stack.removeFirst();
            if (curr != null) {
                ll.add(curr.val);
                stack.addFirst(curr.right);
                curr = curr.right;
            }
        }
        for (int i = 1; i < ll.size(); i++)
            if (ll.get(i - 1) >= ll.get(i)) return false;

        return true;
    }
}
