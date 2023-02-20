class Solution {
    Map<List<Integer>,Integer>map=new HashMap<>();
    List<Integer>price;
    List<List<Integer>>special;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price=price;
        this.special=special;
        List<Integer>empty=new ArrayList<>();
        for(int i=0;i<price.size();i++)empty.add(0);
        map.put(empty,0);
        return dfs(needs);
    }
    public int dfs(List<Integer>needs){
        if(map.containsKey(needs))return map.get(needs);
        int res=calculate(needs);
        for(int i=0;i<special.size();i++){
            List<Integer>remain=subtract(needs,special.get(i));
            if(remain!=null){
                res=Math.min(res,special.get(i).get(special.get(i).size()-1)+dfs(remain));
            }
        }
        map.put(needs,res);
        return res;
    }
    public List<Integer> subtract(List<Integer>needs,List<Integer>offers){
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<needs.size();i++){
            if(offers.get(i)>needs.get(i))return null;
            list.add(needs.get(i)-offers.get(i));
        }
        return list;
    }
    public int calculate(List<Integer>needs){
        int sum=0;
        for(int i=0;i<needs.size();i++){
            sum+=(needs.get(i)*price.get(i));
        }
        return sum;
    }
}
