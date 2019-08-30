"""
The read4 API is already defined for you.

    @param buf, a list of characters
    @return an integer
    def read4(buf):

# Below is an example of how the read4 API can be called.
file = File("abcdefghijk") # File is "abcdefghijk", initially file pointer (fp) points to 'a'
buf = [' '] * 4 # Create buffer with enough space to store characters
read4(buf) # read4 returns 4. Now buf = ['a','b','c','d'], fp points to 'e'
read4(buf) # read4 returns 4. Now buf = ['e','f','g','h'], fp points to 'i'
read4(buf) # read4 returns 3. Now buf = ['i','j','k',...], fp points to end of file
"""
class Solution:
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Number of characters to read (int)
        :rtype: The number of actual characters read (int)
        """
        leng = 0
        buf4 = [' ', ' ', ' ', ' ']
        while n > 4:
            r4 = read4(buf4)
            if r4 < 4:
                buf[leng:leng+r4] = buf4[:r4]
                leng += r4
                return leng
            else:
                buf[leng:leng+4] = buf4[:]
                leng += 4
                n -= 4
        r4 = read4(buf4)
        if r4 < n:
            buf[leng:leng+r4] = buf4[:r4]
            leng += r4
            return leng
        else:
            buf[leng:leng+n] = buf4[:n]
            leng += n
            return leng