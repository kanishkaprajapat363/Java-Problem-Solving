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
        ListNode dummy=new ListNode(0);
        ListNode slow=dummy;
        ListNode fast=dummy;
        dummy.next=head;

        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;

        return dummy.next;

        
    }
}
//Time Complexity: \(O(N)\) — we traverse the linked list using two pointers.
//Auxiliary Space Complexity: \(O(1)\) — we use a constant number of pointers and one dummy node.