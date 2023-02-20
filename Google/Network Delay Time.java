class Solution {
	public int networkDelayTime(int[][] times, int n, int k) {
		int[] store = new int[n+1];
		Queue<int[]> q = new PriorityQueue<>((x,y)->x[1]-y[1]);
		ArrayList<List<int[]>> adj = new ArrayList<>();
		for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
		for(int i=0;i<times.length;i++){
			adj.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
		}
		q.offer(new int[]{k,0});
		Arrays.fill(store,Integer.MAX_VALUE);
		store[0]=0;
		store[k]=0;
		while(!q.isEmpty()){
			int node = q.peek()[0];
			int value = q.peek()[1];
			q.poll();

			for(int[] arr : adj.get(node)){
				int newnode = arr[0];
				int newvalue = arr[1];

				if(value+newvalue<store[newnode]){
					store[newnode]=value+newvalue;
					q.offer(new int[]{newnode, store[newnode]});
				}
			}
		}
		int min=Integer.MIN_VALUE;
		for(int i : store){
			min=Math.max(min,i);
		}
		return min==Integer.MAX_VALUE?-1:min;
	}
}
