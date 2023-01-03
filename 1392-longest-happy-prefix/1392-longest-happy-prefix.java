class Solution {
    public String longestPrefix(String s) {
        int i = 1, len = 0, n = s.length();
        int[] lps = new int[n];

        char a,b;

        while(i<n){
            a = s.charAt(i); 
            b = s.charAt(len);
            if(a==b) lps[i++] = ++len;
            else{
                if(len!=0) len = lps[len-1];
                else lps[i++] = 0;
            }
        }

        return s.substring(0,lps[n-1]);


    }
}