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

        if(head==null || head.next==null){
            return head;
        }

        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while(head!=null){
            if(head.val<x){
                temp1.next = head;
                temp1 = temp1.next;
            }
            else{
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }

        temp1.next = head2.next;
        temp2.next = null;

        return head1.next;

    }
}