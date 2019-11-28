/**
 * PriorityQueue Solution
 * Time O(nlogn) Space O(n)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] i : intervals) {
            if (!pq.isEmpty() && pq.peek() <= i[0]) {
                pq.poll();
            }
            pq.offer(i[1]);
        }
        return pq.size();
    }
    /**
     * treat start time and end time seperately, we need allocate a new room if the current
     * start time is smaller than the end time
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i=0; i<len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int sp = 0, ep = 0, count=0;
        while (sp < len) {
            if (start[sp] < end[ep]) {
                count++;
            } else {
                ep++;
            }
            sp++;
        }
        return count;
    }
}