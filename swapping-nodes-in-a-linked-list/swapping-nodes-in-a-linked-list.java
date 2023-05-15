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
    public ListNode swapNodes(ListNode head, int k) {
        int n =0, m = 0;
        int l = 0;

        ListNode tmp = head;
        ListNode sw = head, sl = head;;
        while(tmp != null){
            l++;
            tmp = tmp.next;
        }
        if(k>l) return null;

        int s = l - k;
        while(k-->1){
            sw = sw.next;
        }
        n = sw.val;
        
        while(s-->0){
            sl = sl.next;
        }

        sw.val =  sl.val;
        sl.val = n;
        return head;
    }
}