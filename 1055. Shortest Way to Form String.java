class Solution {
    public int shortestWay(String source, String target) {
        int index = -1;
        int count = 0;
        for (char c : target.toCharArray()) {
            int temp = source.indexOf(c, index+1);
            if (temp == -1) {
                temp = source.indexOf(c);
                if (temp == -1) {
                    return -1;
                } else {
                    count++;
                    index = temp;
                }
            } else {
                index = temp;
            }
        }
        return count+1;
    }
}