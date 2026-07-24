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

        ListNode head1=head;
        ListNode head2=head;

        while(head1!=null && head1.val>=x){
            head1 = head1.next;
        }

        while(head2!=null && head2.val<x){
            head2 = head2.next;
        }

        if(head1==null && head2!=null){
            return head;
        }
        if(head1!=null && head2==null){
            return head;
        }

        
        ListNode temp=head;
        head = head1;
        ListNode part = head2;

        while(temp!=null){
            if(temp==head1 || temp==head2){
                temp = temp.next;
                continue;
            }

            if(temp==null){
                break;
            }

            if(temp.val<x){
                head1.next = temp;
                head1 = temp;
                temp = temp.next;
                continue;
            }

            if(temp.val>=x){
                head2.next = temp;
                head2 = temp;
                temp = temp.next;
                continue;
            }
        }

        head1.next=part;
        head2.next=null;
        return head;
    }
}