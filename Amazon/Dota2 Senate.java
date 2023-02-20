class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList();
        Queue<Integer> d = new LinkedList();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }
        while (d.size() != 0 && r.size() != 0) {
            int ri = r.peek();
            r.remove();
            int di = d.peek();
            d.remove();
            if (ri < di) {
                r.add(ri + senate.length());
            } else {
                d.add(di + senate.length());
            }
        }
        return (d.size() > 0) ? "Dire" : "Radiant";
    }
}
