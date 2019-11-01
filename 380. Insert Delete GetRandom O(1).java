class RandomizedSet {
    HashMap<Integer, Integer> poss;
    ArrayList<Integer> num;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        poss = new HashMap<>();
        num = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (poss.containsKey(val)) {
            return false;
        } 
        poss.put(val, num.size());
        num.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!poss.containsKey(val)) {
            return false;
        }
        int pos = poss.get(val);
        num.set(pos, num.get(num.size()-1));
        poss.put(num.get(pos), pos);
        num.remove(num.size()-1);
        poss.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int n = rand.nextInt(num.size());
        return num.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */