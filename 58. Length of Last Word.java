class Solution {
    public int lengthOfLastWord(String s) {
        String[] temp = s.trim().split(" ");
        if (temp.length==0) {
            return 0;
        }
        return temp[temp.length-1].length();
    }
}