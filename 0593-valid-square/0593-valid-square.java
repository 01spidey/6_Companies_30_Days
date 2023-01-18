class Solution {
    public double dist(int[] x, int[] y){
        int x1 = x[0], y1 = x[1], x2 = y[0], y2 = y[1];
        double dis = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
        return dis;
    }
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        HashSet<Double> set = new HashSet<>();
        
        set.add(dist(p1, p2));
        set.add(dist(p1, p3));
        set.add(dist(p1, p4));
        set.add(dist(p2, p3));
        set.add(dist(p2, p4));
        set.add(dist(p3, p4));

        System.out.println(set);
        if(set.size()==2 && !set.contains(0.0)) return true;
    

        return false;
    }
}