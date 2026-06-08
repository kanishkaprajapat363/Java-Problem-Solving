/* Structure of linked list node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    
    private Node reverse(Node head) {
        Node prev = null, curr = head;
        
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    Node compute(Node head) {
        if (head == null || head.next == null)
            return head;
        
        // Reverse the list
        head = reverse(head);
        
        int maxSoFar = head.data;
        Node curr = head;
        
        while (curr != null && curr.next != null) {
            if (curr.next.data < maxSoFar) {
                curr.next = curr.next.next; // delete node
            } else {
                curr = curr.next;
                maxSoFar = curr.data;
            }
        }
        
        // Reverse again to restore order
        return reverse(head);
    }
}