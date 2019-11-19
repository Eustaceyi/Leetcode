/**
 * Use hashmap to record numbers, 
 * and check if value-i in the map or if it is the same check for if we have duplicates
 */
class TwoSum {
    HashMap<Integer, Integer> numCount;

    /** Initialize your data structure here. */
    public TwoSum() {
        numCount = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        Integer i = numCount.get(number);
        if (i==null) {
            numCount.put(number, 1);
        } else {
            numCount.put(number, i+1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i : numCount.keySet()) {
            if (numCount.containsKey(value-i) && (value != 2*i || numCount.get(i) >= 2)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */