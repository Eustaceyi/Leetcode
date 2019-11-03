class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] tcount = new int[26];
        for (char t : tasks) {
            tcount[t - 'A']++;
        }
        Arrays.sort(tcount);
        int idle = (tcount[25]-1)*n;
        for (int i=24; i>=0; i--) {
            if (tcount[i] == tcount[25]) {
                idle -= tcount[i]-1;
            } else {
                idle -= tcount[i];
            }
        }
        return idle > 0 ? tasks.length + idle : tasks.length;
    }
}