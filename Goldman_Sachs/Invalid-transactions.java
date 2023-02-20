class Solution {
    public List<String> invalidTransactions(String[] trc) {
        String[] names = new String[trc.length];
        int[] amount = new int[trc.length];
        int[] mins = new int[trc.length];
        String[] city = new String[trc.length];

        String[] arr;
        int n = 0;

        for(String str : trc){
            arr = str.split(",");
            names[n] = arr[0];
            mins[n] = Integer.parseInt(arr[1]);
            amount[n] = Integer.parseInt(arr[2]);
            city[n] = arr[3];
            n++;
        }

        List<Integer> lst = new ArrayList<>();

        String name1, name2, city1, city2;
        int t1, t2, amt;

        for(int i=0;i<trc.length;i++){
            name1 = names[i];
            t1 = mins[i];
            amt = amount[i];
            city1 = city[i];
            
            if(amt>1000) lst.add(i);

            for(int j=0;j<trc.length;j++){
                if(i!=j){
                    name2 = names[j];
                    t2 = mins[j];
                    city2 = city[j];
                    
                    if(name1.equals(name2)){
                        if(!city1.equals(city2)){
                            if(Math.abs(t2-t1)<=60){
                                lst.add(i); lst.add(j);
                            }
                        }
                    }
                }
            }
        }
        
        
        lst = new ArrayList<>(new HashSet<Integer>(lst));
        
        Collections.sort(lst);
        
        List<String> res = new ArrayList<>();
        
        for(int k : lst) res.add(trc[k]);

        return res;
    }
}
