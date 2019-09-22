class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            switch (c) 
            {
                case 'I':
                    res += res < 5 ? 1 : -1;
                    break;
                case 'V':
                    res += res < 10 ? 5 : -5;
                    break;
                case 'X':
                    res += res < 50 ? 10: -10;
                    break;
                case 'L':
                    res += res < 100 ? 50: -50;
                    break;
                case 'C':
                    res += res < 500 ? 100: -100;
                    break;
                case 'D':
                    res += res < 1000? 500 : -500;
                    break;
                case 'M':
                    res += res < 5000? 1000 : -1000;
                    break;
            }
        }
        return res;
    }
}