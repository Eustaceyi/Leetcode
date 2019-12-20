class TimeMap {
    class Node {
        int timestamp;
        String value;
        public Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    private HashMap<String, List<Node>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Node> temp = map.getOrDefault(key, new ArrayList<>());
        temp.add(new Node(timestamp, value));
        map.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        List<Node> temp = map.get(key);
        if (temp == null) {
            return null;
        }
        int lo=0, hi=temp.size()-1;
        while (lo <= hi) {
            int mid = (hi-lo)/2 + lo;
            int t = temp.get(mid).timestamp;
            if (t == timestamp) {
                return temp.get(mid).value;
            } else if (t < timestamp) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        if (hi < 0) {
            return "";
        }
        return temp.get(hi).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */