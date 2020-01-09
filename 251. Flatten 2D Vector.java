class Vector2D {
    private int[][] v;
    private int above;
    private int under;

    public Vector2D(int[][] v) {
        this.v = v;
        above = 0;
        under = 0;
    }
    
    public int next() {
        if (hasNext()) {
            return v[above][under++];
        }
        return 0;
    }

    public boolean hasNext() {
        while (above < v.length && under == v[above].length) {
            above++;
            under = 0;
        }
        return above != v.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */