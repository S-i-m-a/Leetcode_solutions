class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // sort by end ascending; if end equal, start descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int ans = 0;
        int secondLast = -1;  // the smaller of the two most recently selected points
        int last = -1;        // the larger of the two most recently selected points
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end   = interval[1];
            
            if (start <= secondLast) {
                // this interval already contains both selected points → nothing to add
                continue;
            }
            else if (start > last) {
                // interval contains none of the selected points → add two points
                ans += 2;
                secondLast = end - 1;
                last = end;
            }
            else {
                // interval contains exactly one of the selected points → add one point
                ans += 1;
                secondLast = last;
                last = end;
            }
        }
        
        return ans;
    }
}
