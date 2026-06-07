class Solution {
    public String profession(int level, int pos) {
        int setBits = Integer.bitCount(pos - 1);
        return (setBits % 2 == 0) ? "Engineer" : "Doctor";
    }
}