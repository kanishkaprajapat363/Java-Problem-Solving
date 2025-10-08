/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int preIndex = 0;

    public Node constructTree(int[] pre, int[] post) {
        return construct(pre, post, 0, post.length - 1);
    }

    private Node construct(int[] pre, int[] post, int start, int end) {
        // Base case
        if (preIndex >= pre.length || start > end) return null;

        // Create the root node
        Node root = new Node(pre[preIndex++]);

        // If there are no more children, return the node
        if (start == end || preIndex >= pre.length) return root;

        // Find the index of the next preorder element in postorder
        int index = start;
        while (index <= end && post[index] != pre[preIndex]) index++;

        // Construct left and right subtrees recursively
        if (index <= end) {
            root.left = construct(pre, post, start, index);
            root.right = construct(pre, post, index + 1, end - 1);
        }

        return root;
    }
}
