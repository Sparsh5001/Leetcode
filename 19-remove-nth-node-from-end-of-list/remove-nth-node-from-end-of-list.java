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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        head = rev(head);
        ListNode temp=head;
        if(n==1){
            head = head.next;
            return rev(head);
        }
        while(n>2){
            temp=temp.next;
            n--;
        }
        temp.next = temp.next.next;
        return rev(head);
    }

    public ListNode rev(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}