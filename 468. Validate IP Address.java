class Solution {
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') >= 0) {
            String[] parts = IP.split("\\.", 4);
            System.out.println(parts.length);
            if (parts.length != 4) {
                return "Neither";
            }
            int temp;
            boolean notIPv4 = false;
            for (String p : parts) { 
                temp = 0;
                if (p.length() == 0 || (p.length()>1 && p.charAt(0)=='0')) {
                    return "Neither";
                }
                for (int i=0; i<p.length(); i++) {
                    char c = p.charAt(i);
                    if (c < '0' || c > '9' || temp >= 256) {
                        notIPv4 = true;
                        break;
                    }
                    temp = temp * 10 + (c - '0');
                }
                if (notIPv4) {
                    return "Neither";
                }
                if (temp >= 256) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (IP.indexOf(':') >= 0) {
            String[] parts = IP.split(":", 8);
            if (parts.length != 8) {
                return "Neither";
            }
            Set<Character> set = new HashSet<>();
            for (int i=0; i<10; i++) {
                set.add((char)(i+'0'));
            }
            for (int i=0; i<6; i++) {
                set.add((char)(i+'a'));
                set.add((char)(i+'A'));
            }
            boolean notIPv6 = false;
            for (String p : parts) {
                if (p.length() > 4 || p.length()==0) {
                    return "Neither";
                }
                for (char c : p.toCharArray()) {
                    if (!set.contains(c)) {
                        notIPv6 = true;
                        break;
                    }
                }
                if (notIPv6) {
                    return "Neither";
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}