class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                ls.add(sb.toString());
                ls.add(Character.toString(c));
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        ls.add(sb.toString());
        return compute(ls, 0, ls.size()-1);
    }
    private List<Integer> compute(List<String> ls, int st, int ed) {
        List<Integer> res = new ArrayList<>();
        if (st == ed) {
            res.add(Integer.parseInt(ls.get(st)));
            return res;
        }
        if (ed - st == 2) {
            String sign = ls.get((ed-st)/2+st);
            switch (sign) {
                case "+":
                    res.add(Integer.parseInt(ls.get(st)) + Integer.parseInt(ls.get(ed)));
                    break;
                case "-":
                    res.add(Integer.parseInt(ls.get(st)) - Integer.parseInt(ls.get(ed)));
                    break;
                case "*":
                    res.add(Integer.parseInt(ls.get(st)) * Integer.parseInt(ls.get(ed)));
                    break;
            }
            return res;
        }
        for (int i = st+1; i < ed; i+=2) {
            String sign = ls.get(i);
            List<Integer> r1 = compute(ls, st, i-1);
            List<Integer> r2 = compute(ls, i+1, ed);
            for (int rr1 : r1) {
                for (int rr2 : r2) {
                    switch (sign) {
                        case "+":
                            res.add(rr1 + rr2);
                            break;
                        case "-":
                            res.add(rr1 - rr2);
                            break;
                        case "*":
                            res.add(rr1 * rr2);
                            break;
                    }
                }
            }
        }
        return res;
    }
}