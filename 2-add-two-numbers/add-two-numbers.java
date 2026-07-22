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

        if (length(l2) > length(l1)) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode temp1 = l1 ;
        ListNode temp2 = l2 ;
        ListNode prev = null;
        int carry = 0;

        while(temp1!=null && temp2!=null){

            int sum = temp1.val + temp2.val + carry;
            temp1.val = sum % 10;
            carry = sum / 10;

            prev = temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1!=null){
            int sum = temp1.val + carry;
            temp1.val = sum % 10;
            carry = sum / 10;

            prev = temp1;
            temp1 = temp1.next;
        }
        
        if(carry == 1){
            prev.next = new ListNode(1);
        }
        return l1;
    }
    
    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}