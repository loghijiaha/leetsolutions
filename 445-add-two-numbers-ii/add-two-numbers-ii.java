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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        Stack<Integer> st1 = new Stack();
        Stack<Integer> st2 = new Stack();

        String x = "", y = "";
        while(head1 != null){
            st1.push(head1.val);
            head1 = head1.next;
            
        }

        while(head2 != null){
            st2.push(head2.val);
            head2 = head2.next;
        }

        String d = "";
        int carry = 0;

        while(!st1.isEmpty() || !st2.isEmpty()){
            int tmp = 0;
            if(!st1.isEmpty()){
                tmp += st1.pop();
            }
            if(!st2.isEmpty()){
                tmp += st2.pop();
            }

            tmp+=carry;
            carry = tmp/10;
            tmp = tmp % 10;
            d = tmp + d;
        }
        if(carry > 0){
            d = carry + d;
        }

        ListNode ans = new ListNode();
        ListNode tmp = ans;
        for(char i: d.toCharArray()){
            tmp.next = new ListNode(i-'0');
            tmp = tmp.next;
        }
        return ans.next;

    }
}