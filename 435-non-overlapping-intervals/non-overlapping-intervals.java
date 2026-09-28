import java.util.Arrays;
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals according to ending time
        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[1], b[1]));
                int count = 1;
                // End time of first selected interval
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // No overlap
            if (intervals[i][0] >= end) {
                count++;
                // Update end to current interval's end
                end = intervals[i][1];
            }
        }
        // Total - intervals we kept
        return intervals.length - count;
    }
}