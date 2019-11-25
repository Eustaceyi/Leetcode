/**
 * A more compact version
 * Also O(1) Space
 */
class Solution {
    public int calculate(String s) {
        int result=0, curr=0, temp=0;   
        char lastSign = '+';
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            } else if (c != ' ') {
                switch (lastSign) {
                    case '+':
                        result += temp;
                        temp = curr;
                        break;
                    case '-':
                        result += temp;
                        temp = -curr;
                        break;
                    case '*':
                        temp *= curr;
                        break;
                    case '/':
                        temp /= curr;
                        break;
                }
                lastSign = c;
                curr = 0;
            }
        }
        switch (lastSign) {
            case '+':
                result += temp;
                temp = curr;
                break;
            case '-':
                result += temp;
                temp = -curr;
                break;
            case '*':
                temp *= curr;
                break;
            case '/':
                temp /= curr;
                break;
        }
        result += temp;
        return result;
    }
}
/**
 * My solution without stack
 * Time O(n) Space O(1)
 */
class Solution {
    public int calculate(String s) {
        int result=0, curr=0, temp=0;        
        boolean isPlus = true;
        boolean isTimes = true;
        boolean containsMulti = false;
        boolean multiplyWithZero = false;
        int i=0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c-'0');
            } else if (c == '+' || c == '-') {
                if (!multiplyWithZero) {
                    if (containsMulti) {
                        if (isTimes) {
                            curr = temp * curr;
                        } else {
                            curr = temp / curr;
                        }
                    }
                    if (isPlus) {
                        result += curr;
                    } else {
                        result -= curr;
                    }
                }
                multiplyWithZero = false;
                containsMulti = false;
                isPlus = (c == '+');
                curr = 0;
                temp = 0;
            } else if (c == '*' || c == '/') {
                if (multiplyWithZero) {
                    temp = 0;
                } else {
                    if (curr == 0) {
                        multiplyWithZero = true;
                    }
                    if (containsMulti) {
                        if (isTimes) {
                            temp *= curr;
                        } else {
                            temp /= curr;
                        }
                    } else {
                        temp = curr;
                    }
                    
                }
                curr = 0;
                isTimes = (c == '*');
                containsMulti = true;
            }
            i++;
        }
        if (!multiplyWithZero) {
            if (containsMulti) {
                if (isTimes) {
                    curr = temp * curr;
                } else {
                    curr = temp / curr;
                }
            }
            if (isPlus) {
                result += curr;
            } else {
                result -= curr;
            }
        }
        return result;
    }
}