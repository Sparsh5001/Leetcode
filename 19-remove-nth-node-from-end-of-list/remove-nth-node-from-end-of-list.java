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
        if(head == null){
            return null;
        }
        ListNode temp = head;
        int length=1;
        while(temp.next!=null){
            length++;
            temp = temp.next;
        }
        temp = head;
        int target = length-n;
        if(length==1){
            return null;
        }
        if(target == 0){
            head = head.next;
            return head;
        }
        for(int i = 1 ; i <target ; i++){
            temp = temp.next;
        }
        ListNode temp2 = temp.next;
        temp.next = temp2.next;
        return head;
    }
}