class Solution {
    public int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] map = new int[3];
        int count = 0;
        int start = 0;
        int ans = 0;
        for(int end = 0;end<n;end++) {
            map[arr[end]-'a']++;
            if(map[arr[end]-'a'] == 1) count++;
            while(count == 3) {
                ans += n-end;
                map[arr[start]-'a']--;
                if(map[arr[start]-'a'] == 0) count--;
                start++;
            }
        }
        return ans;
    }
}
