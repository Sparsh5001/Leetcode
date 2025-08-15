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
    public int[] nextLargerNodes(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            length++;
        }
        int[] arr = new int[length];
        ListNode check;
        temp = head;
        int i =0;
        while(temp!=null){
            check = temp;
            while(check!=null && check.val <= temp.val){
                check = check.next;
            }
            if(check!=null){
                arr[i] = check.val;
              
            }
            i++;
            
            temp = temp.next;
        }
        return arr;
    }
}