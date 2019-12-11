class Solution {
    Map<Integer, String> map;
    Map<Integer, String> digits;
    
    public Solution() {
        map = new HashMap<>();
        map.put(100, "One Hundred ");
        map.put(200, "Two Hundred ");
        map.put(300, "Three Hundred ");
        map.put(400, "Four Hundred ");
        map.put(500, "Five Hundred ");
        map.put(600, "Six Hundred ");
        map.put(700, "Seven Hundred ");
        map.put(800, "Eight Hundred ");
        map.put(900, "Nine Hundred ");
        map.put(10, "Ten ");
        map.put(11, "Eleven ");
        map.put(12, "Twelve ");
        map.put(13, "Thirteen ");
        map.put(14, "Fourteen ");
        map.put(15, "Fifteen ");
        map.put(16, "Sixteen ");
        map.put(17, "Seventeen ");
        map.put(18, "Eighteen ");
        map.put(19, "Nineteen ");
        map.put(20, "Twenty ");
        map.put(30, "Thirty ");
        map.put(40, "Forty ");
        map.put(50, "Fifty ");
        map.put(60, "Sixty ");
        map.put(70, "Seventy ");
        map.put(80, "Eighty ");
        map.put(90, "Ninety ");
        map.put(1, "One ");
        map.put(2, "Two ");
        map.put(3, "Three ");
        map.put(4, "Four ");
        map.put(5, "Five ");
        map.put(6, "Six ");
        map.put(7, "Seven ");
        map.put(8, "Eight ");
        map.put(9, "Nine ");
        digits = new HashMap<>();
        digits.put(0, "");
        digits.put(1, "Thousand ");
        digits.put(2, "Million ");
        digits.put(3, "Billion ");
        digits.put(4, "Trillion ");
        digits.put(5, "Quadrillion ");
    }
    
    public String numberToWords(int num) {
        LinkedList<String> ls = new LinkedList<>();
        if (num == 0) {
            return "Zero";
        }
        int count = 0;
        while (num > 0) {
            ls.addFirst(digits.get(count++));
            int temp = num % 1000;
            if (temp == 0) {
                ls.removeFirst();
                num /= 1000;
                continue;
            }
            String stemp = number2Words(temp);
            ls.addFirst(stemp);
            num /= 1000;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ls) {
            sb.append(s);
        }
        return sb.toString().trim();
    }
    
    private String number2Words(int num) {
        StringBuilder sb = new StringBuilder();
        if (num/100 > 0) {
            sb.append(map.get(num/100*100));
        }
        num -= num/100*100;
        if (num >= 20) {
            sb.append(map.get(num/10*10));
        } else if (num >= 10 && num < 20) {
            sb.append(map.get(num));
            return sb.toString();
        }
        num -= num/10*10;
        if (num > 0) {
            sb.append(map.get(num));
        }
        return sb.toString();
    }
}