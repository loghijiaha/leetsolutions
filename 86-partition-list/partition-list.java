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
    public ListNode partition(ListNode head, int x) {
        Queue<Integer> pq = new ArrayDeque<>();
        ListNode f = head;
        while(f != null){
            if(f.val < x){
                pq.offer(f.val);
            }
            f = f.next;
        }
        

        ListNode s = new ListNode();
        ListNode ans = s;
        ListNode b = head;
        while(!pq.isEmpty() && b != null){
            if(pq.peek() <= b.val){
                ans.next = new ListNode(pq.poll());
                ans = ans.next;
                continue;
            }
            b = b.next;
        }

        while(b != null){
            if(b.val >= x){ 
                ans.next = new ListNode(b.val);
                ans = ans.next;
            }
            b = b .next;
        }

        return s.next;

    }
}