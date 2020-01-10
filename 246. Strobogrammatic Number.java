class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');
        int half = num.length() / 2;
        int len = num.length();
        for (int i=0; i<half; i++) {
            char lo = num.charAt(i);
            char hi = num.charAt(len-1-i);
            if (!map.containsKey(lo) || hi != map.get(lo)) {
                return false;
            }
        }
        if (len%2 != 0) {
            if (num.charAt(half) != '1' && num.charAt(half) != '8' && num.charAt(half) != '0') {
                return false;
            }
        }
        return true;
    }
}