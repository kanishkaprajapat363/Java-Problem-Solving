class Solution {
    int res;

    int findMaxSum(Node root) {
        res = Integer.MIN_VALUE;
        maxPath(root);
        return res;
    }

    int maxPath(Node root) {
        if (root == null)
            return 0;

        // Recursively get max path sum from left and right subtrees
        int left = Math.max(0, maxPath(root.left));  // ignore negatives
        int right = Math.max(0, maxPath(root.right));

        // Maximum path sum passing through this node
        int currSum = root.data + left + right;

        // Update global maximum
        res = Math.max(res, currSum);

        // Return max gain to parent
        return root.data + Math.max(left, right);
    }
}
