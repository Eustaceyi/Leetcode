/**
 * custom sorting
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] ns = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            ns[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ns, new Digits());
        if (ns[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ns) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}
class Digits implements Comparator<String> {
    public int compare(String a, String b) {
        return (b + a).compareTo(a + b);
    }
}