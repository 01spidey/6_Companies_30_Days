
class StockPrice {
    PriorityQueue<int[]> minHeap;
    PriorityQueue<int[]> maxHeap;
    
    Map<Integer,Integer> map;
    int lastTime = 0;
    public StockPrice() {
        minHeap = new PriorityQueue<int[]>( (a,b) ->  Integer.compare(a[1],b[1]));
        maxHeap = new PriorityQueue<int[]>( (a,b) ->  -Integer.compare(a[1],b[1]));
        map = new HashMap();
    }
    public void update(int timestamp, int price) {
        
       lastTime = Math.max(timestamp, lastTime);
       map.put(timestamp, price);
       minHeap.add(new int[]{timestamp, price});
       maxHeap.add(new int[]{timestamp, price});
    }
    public int current() {
        return map.get(lastTime);
    }
    public int maximum() {
        while(map.get(maxHeap.peek()[0]) != maxHeap.peek()[1]){
            maxHeap.poll();
        }
        return maxHeap.peek()[1];
    }
    public int minimum() {
        while(map.get(minHeap.peek()[0]) != minHeap.peek()[1]){
            minHeap.poll();
        }
        return minHeap.peek()[1];
    }
}
