class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        List<String> ans = new ArrayList<>();
        generate(new char[n], 0, n-1, ans, map);
        return ans;
    }
    
    private void generate(char[] arr, int left, int right, List<String> ans, Map<Character, Character> map) {
        if (left > right) {
            ans.add(String.valueOf(arr));
            return;
        }
        if (left == right) {
            arr[left] = '0';
            ans.add(String.valueOf(arr));
            arr[left] = '1';
            ans.add(String.valueOf(arr));
            arr[left] = '8';
            ans.add(String.valueOf(arr));
            return;
        }
        for (char c : map.keySet()) {
            if (left==0 && c=='0') continue;
            arr[left] = c;
            arr[right] = map.get(c);
            generate(arr, left+1, right-1, ans, map);
        }
    }
}