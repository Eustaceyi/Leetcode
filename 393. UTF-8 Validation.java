class Solution {
    public boolean validUtf8(int[] data) {
        for (int i=0; i<data.length; i++) {
            if ((data[i] & 0xF8) == 0xF0) {
                // 4 byte
                int count = 1;
                while (count <= 3) {
                    if (i+count >= data.length || (data[i+count] & 0xC0) != 0x80) {
                        return false;
                    }
                    count++;
                }
                i += count-1;
            } else if ((data[i] & 0xF0) == 0xE0) {
                // 3 byte
                int count = 1;
                while (count <= 2) {
                    if (i+count >= data.length || (data[i+count] & 0xC0) != 0x80) {
                        return false;
                    }
                    count++;
                }
                i += count-1;
            } else if ((data[i] & 0xE0) == 0xC0) {
                // 2 byte
                int count = 1;
                while (count <= 1) {
                    if (i+count >= data.length || (data[i+count] & 0xC0) != 0x80) {
                        return false;
                    }
                    count++;
                }
                i += count-1;
            } else if ((data[i] & 0x80) == 0) {
                // 1 byte
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}