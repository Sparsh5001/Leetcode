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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return list1;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode head;

        if(list1.val <= list2.val){
            head = list1;
        }else{
            head = list2;
        }
        ListNode hold;
        while(list1!=null || list2!=null){
            if(list1.val <= list2.val){
                while(list1.next!=null && list1.next.val<=list2.val){
                    list1=list1.next;
                }
                hold = list1.next;
                list1.next = list2;
                list1 = hold;
                if(list1 == null){
                    break;
                }
            }else{
                while(list2.next!=null && list2.next.val<=list1.val){
                    list2=list2.next;
                }
                hold = list2.next;
                list2.next = list1;
                list2 = hold;
                if(list2 == null){
                    break;
                }
            }
        }
    return head;
    }
}