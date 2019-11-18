/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int curr = 0;
        char[] b = new char[4];
        while (curr < n) {
            int ret = read4(b);
            if (ret < 4 && curr+ret<=n) {
                int count = 0;
                while (count < ret) {
                    buf[curr++] = b[count++];
                }
                return curr;
            } else if (curr+ret>n) {
                int count = 0;
                while (curr < n) {
                    buf[curr++] = b[count++];
                }
                return n;
            } else {
                int count = 0;
                while (count < 4) {
                    buf[curr++] = b[count++];
                }
            }
        }
        return n;
    }
}