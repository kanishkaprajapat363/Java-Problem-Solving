class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count = 0;
    }

    TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
            curr.count++;
        }
    }

    private String getPrefix(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            curr = curr.child[idx];
            sb.append(ch);

            if (curr.count == 1) {
                break;
            }
        }

        return sb.toString();
    }

    public ArrayList<String> findPrefixes(String[] arr) {

        for (String word : arr) {
            insert(word);
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String word : arr) {
            ans.add(getPrefix(word));
        }

        return ans;
    }
}