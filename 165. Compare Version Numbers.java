class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int count = 0;
        while (count < Math.min(v1.length, v2.length)) {
            if (Integer.parseInt(v1[count]) > Integer.parseInt(v2[count])) {
                return 1;
            } else if (Integer.parseInt(v1[count]) < Integer.parseInt(v2[count])) {
                return -1;
            } else {
                count++;
            }
        }
        while (count < v1.length) {
            if (Integer.parseInt(v1[count]) != 0) {
                return 1;
            }
            count++;
        }
        while (count < v2.length) {
            if (Integer.parseInt(v2[count]) != 0) {
                return -1;
            }
            count++;
        }
        return 0;
    }
}