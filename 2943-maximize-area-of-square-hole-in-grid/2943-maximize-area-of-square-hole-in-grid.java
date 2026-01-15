import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // longest streak of consecutive horizontal removals
        int longestH = longestConsecutive(hBars);
        // longest streak of consecutive vertical removals
        int longestV = longestConsecutive(vBars);

        // side of square = min(maxH, maxV) + 1
        int side = Math.min(longestH, longestV) + 1;
        return side * side;
    }

    // find longest run of consecutive ints in arr
    private int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int longest = 1;
        int current = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 1;
            }
        }
        return longest;
    }
}
