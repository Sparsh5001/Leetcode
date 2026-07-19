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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode cur = head.next;
        ListNode prev = head;

        while(cur!=null){
            if(cur.val != prev.val){
                prev.next = cur;
                prev = prev.next;
                cur=cur.next;
            }else{
                cur=cur.next;
            }
        }
        prev.next = cur;
        return head;
    }
}