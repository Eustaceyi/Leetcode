class Solution {
    private HashMap<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ret = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        ret.add("");
        for (int i=0; i<digits.length(); i++) {
            char c = digits.charAt(i);
            String letters = map.get(c);
            while (ret.peek().length() == i) {
                String toadd = ret.remove(0);
                for (char ctoadd : letters.toCharArray()) {
                    ret.add(toadd + ctoadd);
                }
            }
        }
        return ret;
    }
}