/* Structure of Binary Tree Node
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
    int maxLen = 1;

    public int longestConsecutive(Node root) {
        if (root == null) return -1;

        dfs(root, root.data - 1, 0);

        return maxLen == 1 ? -1 : maxLen;
    }

    private void dfs(Node node, int parentVal, int currLen) {
        if (node == null) return;

        if (node.data == parentVal + 1)
            currLen++;
        else
            currLen = 1;

        maxLen = Math.max(maxLen, currLen);

        dfs(node.left, node.data, currLen);
        dfs(node.right, node.data, currLen);
    }
}