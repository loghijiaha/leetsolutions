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
    public int pairSum(ListNode head) {
        List<Integer> mp = new ArrayList<>();
        while(head != null){
            mp.add(head.val);
            head = head.next;
        }

        int ans = 0;
        for(int i=0 ; i<mp.size(); i++){
            ans = Math.max(ans, mp.get(i)+mp.get(mp.size()-i-1));
        }
        return ans;
        
    }
}