/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }
    
    private void preorder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        
        ans.add(root.data);      // Visit root
        preorder(root.left, ans);  // Traverse left
        preorder(root.right, ans); // Traverse right
    }
}