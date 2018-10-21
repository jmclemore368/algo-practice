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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();

        Deque<TreeNode> leftToRight = new LinkedList<>();
        Deque<TreeNode> rightToLeft = new LinkedList<>();

        leftToRight.addFirst(root);
        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {

            List<Integer> leftToRightList = new LinkedList<>();
            while(!leftToRight.isEmpty()) {
                TreeNode node = leftToRight.removeFirst();
                if (node != null) {
                    leftToRightList.add(node.val);
                    rightToLeft.addFirst(node.left);
                    rightToLeft.addFirst(node.right);
                }
            }
            if (!leftToRightList.isEmpty())
                ret.add(leftToRightList);

            List<Integer> rightToLeftList = new LinkedList<>();
            while(!rightToLeft.isEmpty()) {
                TreeNode node = rightToLeft.removeFirst();
                if (node != null) {
                    rightToLeftList.add(node.val);
                    leftToRight.addFirst(node.right);
                    leftToRight.addFirst(node.left);
                }
            }
            if (!rightToLeftList.isEmpty())
                ret.add(rightToLeftList);
        }

        return ret;
    }
}
