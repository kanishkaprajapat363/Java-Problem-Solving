class Solution {
    public String chooseSwap(String s) {
        int n = s.length();

        int[] pos = new int[26];
        for (int i = 0; i < 26; i++) pos[i] = -1;

        for (int i = 0; i < n; i++) {
            if (pos[s.charAt(i) - 'a'] == -1)
                pos[s.charAt(i) - 'a'] = i;
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int cur = arr[i] - 'a';

            for (int ch = 0; ch < cur; ch++) {
                if (pos[ch] > pos[cur]) {
                    char a = arr[i];
                    char b = (char) ('a' + ch);

                    for (int j = 0; j < n; j++) {
                        if (arr[j] == a)
                            arr[j] = b;
                        else if (arr[j] == b)
                            arr[j] = a;
                    }

                    return new String(arr);
                }
            }
        }

        return s;
    }
}