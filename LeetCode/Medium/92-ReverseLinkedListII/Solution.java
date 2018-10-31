/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /*
        Keep ref to head of the entire list, and sublist (needed as shown later)
            sh
            dh -> 1 -> 2 -> 3 -> 4 -> 5 -> x
        */

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode subListHead = dummyHead;
        /*
            Want to start at the m-th node
                  sh   P
            dh -> 1 -> 2 -> 3 -> 4 -> 5 -> x
        */
        ListNode prev = head;
        int numAdvances = m - 1;
        while (numAdvances > 0) {
            subListHead = prev;
            prev = prev.next;
            numAdvances--;
        }

        /*
            Reverse the sublist (m, n)
                   h     P    C,N
            dh -> 1 -> ( 2 ->  3  ->  4 ) -> 5 -> x
        */
        ListNode curr = prev.next;
        ListNode next = prev.next;
        int numReversals = n - m;
        while (numReversals > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            numReversals--;
        }

        /*
            Correct integrity of the list
                  sh                  P     C,N
            dh -> 1 -> ( 2 ->  3  <-  4 )    5 -> x
                           <-
        */
        subListHead.next.next = curr;
        subListHead.next = prev;

        return dummyHead.next;
    }
}
