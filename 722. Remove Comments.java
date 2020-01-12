class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }
}

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean in = false;
        for (String s : source) {
            int i=0, len = s.length();
            while (i<len) {
                if (!in && i+1<len && s.charAt(i) == '/' && s.charAt(i+1) == '*') {
                    in = true;
                    i++;
                } else if (in && i+1<len && s.charAt(i) == '*' && s.charAt(i+1) == '/') {
                    in = false;
                    i++;
                } else if (!in && i+1<len && s.charAt(i) == '/' && s.charAt(i+1) == '/') {
                    break;
                } else if (!in) {
                    sb.append(s.charAt(i));
                }
                i++;
            }
            if (!in && sb.length()>0) {
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ans;
    }
}