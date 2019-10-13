class PhoneDirectory {
    private List<Integer> unused;
    private Set<Integer> used;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.unused = new LinkedList<Integer>();
        this.used = new HashSet<Integer>(maxNumbers);
        for (int i=0; i < maxNumbers; i++) {
            this.unused.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (this.unused.size() == 0) {
            return -1;
        }
        int number = this.unused.remove(0);
        this.used.add(number);
        return number;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (this.used.contains(number)) {
            return false;
        } else {
            return true;
        }
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (this.used.contains(number)) {
            this.used.remove(number);
            this.unused.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */