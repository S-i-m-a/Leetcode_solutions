public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) return rotations;
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int x, int[] tops, int[] bottoms) {
        int rotationsTop = 0, rotationsBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != x && bottoms[i] != x) return -1;
            else if (tops[i] != x) rotationsTop++;
            else if (bottoms[i] != x) rotationsBottom++;
        }
        return Math.min(rotationsTop, rotationsBottom);
    }
}
