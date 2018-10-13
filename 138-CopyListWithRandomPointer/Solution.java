/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        // Old Ref -> New Ref
        Map<RandomListNode, RandomListNode> hm = new HashMap<>();

        RandomListNode curr = head;
        while (curr != null) {
            if (!hm.containsKey(curr)) {
                RandomListNode copyCurr = new RandomListNode(curr.label);
                hm.put(curr, copyCurr);
            }
            if (curr.next != null && !hm.containsKey(curr.next)) {
                RandomListNode copyNext = new RandomListNode(curr.next.label);
                hm.put(curr.next, copyNext);
            }
            if (curr.random != null && !hm.containsKey(curr.random)) {
                RandomListNode copyRandom = new RandomListNode(curr.random.label);
                hm.put(curr.random, copyRandom);
            }
            hm.get(curr).next = hm.get(curr.next);
            hm.get(curr).random = hm.get(curr.random);
            curr = curr.next;
        }
        return hm.get(head);
    }
}
