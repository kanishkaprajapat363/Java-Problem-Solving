import java.util.*;

class Solution {
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store hd -> node.data sorted by hd
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // Overwrite every time for bottom view
            map.put(hd, node.data);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        // Traditional for loop to collect values
        ArrayList<Integer> values = new ArrayList<>(map.values());
        for (int i = 0; i < values.size(); i++) {
            result.add(values.get(i));
        }

        return result;
    }
}
