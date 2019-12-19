class Solution {
    class Log implements Comparable<Log>{
        String id;
        String con;
        String ori;
        boolean digit = false;
        int order;
        
        public Log(String ori, int order) {
            this.ori = ori;
            this.order = order;
            int temp = ori.indexOf(' ');
            id = ori.substring(0, temp);
            con = ori.substring(temp+1);
            if (Character.isDigit(con.charAt(0))) {
                digit = true;
            }
        }
        
        public String toString() {
            return id + "," + con + "," + digit;
        }
        
        @Override
        public int compareTo(Log that) {
            if (this.digit && that.digit) {
                // all digit
                return this.order - that.order;
            } else if (this.digit && !that.digit) {
                // this is digit, that is letter
                return 1;
            } else if (!this.digit && that.digit) {
                // this is letter, that is digit
                return -1;
            } else {
                // all letter
                if (this.con.compareTo(that.con)==0) {
                    return this.id.compareTo(that.id);
                }
                return this.con.compareTo(that.con);
            }
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        Log[] ls = new Log[logs.length];
        for (int i=0; i<logs.length; i++) {
            ls[i] = new Log(logs[i], i);
        }
        Arrays.sort(ls);
        for (int i=0; i<logs.length; i++) {
            logs[i] = ls[i].ori;
        }
        return logs;
    }
}