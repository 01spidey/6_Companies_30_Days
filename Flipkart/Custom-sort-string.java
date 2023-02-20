class Solution {

    public String customSortString(String order, String s) {
        Map<Integer,List<Character>> map = new TreeMap<>();
        for(int i = 0;i < s.length();i++){
            List<Character> tmp = new ArrayList<>();
            try{
                tmp = map.get(order.indexOf(s.charAt(i)));
            }catch(Exception e){

            }
            if(tmp == null) tmp = new ArrayList<>();
            tmp.add(s.charAt(i));
            map.put(order.indexOf(s.charAt(i)),tmp);
        }
        String result = "";
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            for(Character ch : entry.getValue()){
                result += ch;
            }
        }
        return result;
    }
}
