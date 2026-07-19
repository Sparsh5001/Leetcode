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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode temp_fast = head;
        if(head==null || head.next==null){
            return head;
        }
        if(head.next.next == null){
            temp=head.next;
            temp.next = head;
            head.next = null;
            head = temp;
            return head;
        }

        temp = head.next;
        temp_fast = head.next.next;


        temp.next=head;
        head.next=null;
        head = temp;
        temp = temp_fast;
        temp_fast = temp_fast.next;

        while(temp_fast!=null){
            temp.next=head;
            head = temp;
            temp = temp_fast; 
            temp_fast = temp_fast.next;
        }
        temp.next = head;
        head = temp;
        return head;
    }
}