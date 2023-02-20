class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        TreeMap<Long,Integer> map = new TreeMap<>();
        for(int i=0; i<asteroids.length; i++){
            map.put((long)(asteroids[i]),map.getOrDefault((long)asteroids[i],0)+1);
        }

        long curMas = mass;
        while(map.size()!=0){
            System.out.println(curMas);
            Long key = map.lowerKey(curMas+1);
            if(key!=null){
                curMas+=key;
                map.put(key,map.get(key)-1);
                if(map.get(key)==0){
                    map.remove(key);
                }
            }else{
                break;
            }
        } 
        System.out.println(map.size());
        if(map.size()==0) return true;
        return false;    
    }
}
