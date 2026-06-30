import java.util.*;

class Solution {

    static class Meeting {
        int start, finish, index;

        Meeting(int s, int f, int i) {
            start = s;
            finish = f;
            index = i;
        }
    }

    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {

        int n = s.length;

        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(s[i], f[i], i + 1));
        }

        Collections.sort(meetings, (a, b) -> {
            if (a.finish != b.finish)
                return a.finish - b.finish;
            return a.index - b.index;
        });

        ArrayList<Integer> ans = new ArrayList<>();

        int lastFinish = -1;

        for (Meeting m : meetings) {
            if (m.start > lastFinish) {
                ans.add(m.index);
                lastFinish = m.finish;
            }
        }

        Collections.sort(ans);

        return ans;
    }
}