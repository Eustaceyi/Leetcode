class Solution {
    public int compress(char[] chars) {
        char prev = chars[0];
        int count = 1;
        int write = 0;
        for (int i=1; i<chars.length; i++) {
            if (chars[i] != prev) {
                if (count == 1) {
                    chars[write++] = prev;
                    prev = chars[i];
                    count = 1;
                } else {
                    chars[write++] = prev;
                    int currpos = write;
                    while (count != 0) {
                        chars[write++] = (char)(count % 10 + '0');
                        count /= 10;
                    }
                    int lastpos = write-1;
                    while (currpos < lastpos) {
                        char temp = chars[currpos];
                        chars[currpos] = chars[lastpos];
                        chars[lastpos] = temp;
                        currpos++; lastpos--;
                    }
                    prev = chars[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        if (count == 1) {
            chars[write++] = prev;
        } else {
            chars[write++] = prev;
            int currpos = write;
            while (count != 0) {
                chars[write++] = (char)(count % 10 + '0');
                count /= 10;
            }
            int lastpos = write-1;
            while (currpos < lastpos) {
                char temp = chars[currpos];
                chars[currpos] = chars[lastpos];
                chars[lastpos] = temp;
                currpos++; lastpos--;
            }
        }
        return write;
    }
}