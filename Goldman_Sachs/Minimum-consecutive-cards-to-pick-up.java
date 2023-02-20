class Solution {
    public int minimumCardPickup(int[] cards) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, dis = 0;
        boolean flag = false;

        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                flag = true;
                dis = i-map.get(cards[i])+1;
                if(dis<min) min = dis;
            }
            map.put(cards[i], i);
        }

        return flag ? min:-1;
    }
}
