class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] project = new int[n][2];
        
        for(int i = 0; i < n; i++){
            project[i][0] = capital[i];
            project[i][1] = profits[i];
        }
        
        Arrays.sort(project, (a,b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        
        int i = 0;
        while(k-- > 0 ){
            while(i < n && project[i][0] <= w){
                pq.add(project[i]);
                i++;
            }
            if(pq.isEmpty()){
                return w;
            }
            w += pq.peek()[1];
            pq.poll();
        }
        
        return w;
    }
}
