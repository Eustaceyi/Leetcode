class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i =0; i<numRows; i++) {
            rows.add(new StringBuilder());
        }
        int currRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows-1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}