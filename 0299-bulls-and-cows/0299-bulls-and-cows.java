class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> seen=new HashMap<>();
        int bull=0;
        int cow=0;
        for(int i=0;i<secret.length();i++)
        {
            char c=secret.charAt(i);
            char ch=guess.charAt(i);
            if(c==ch)
                bull++;
            else
            {
            seen.put(c,seen.getOrDefault(c,0)+1);
            }
        }
        for(int i=0;i<guess.length();i++)
        {
            char ch=secret.charAt(i);
            char c=guess.charAt(i);
            if(c!=ch && seen.getOrDefault(c,0)>0)
            {
                cow++;
                seen.put(c,seen.get(c)-1);
            }
        }
        return bull+"A"+cow+"B";
    }
}