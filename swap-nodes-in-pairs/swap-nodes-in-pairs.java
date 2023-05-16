/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = head, nextu = null;
        if(head != null){
            nextu = head.next;
        }
        while(prev != null && nextu != null){
            int tmp = nextu.val;
            nextu.val = prev.val;
            prev.val = tmp;

            prev = prev.next.next;
            if(nextu.next != null){
                nextu = nextu.next.next;
            }
        }
        return head;

        
    }
}