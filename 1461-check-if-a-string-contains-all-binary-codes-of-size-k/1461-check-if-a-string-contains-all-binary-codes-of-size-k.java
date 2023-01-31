class Solution {
    Trie root = new Trie();
    private boolean check(int[] arr,int k,int i)
    {
        if(i == k)
        {
            Trie curr = root;
            for(int j = 0;j<k;j++)
            {
                if(curr.child[arr[j]]==null)
                    return false;
                curr = curr.child[arr[j]];
            }
            return true;
        }
        arr[i] = 0;
        boolean ans = check(arr,k,i+1);
        if(ans == false)
            return false;
        arr[i] = 1;
        return check(arr,k,i+1);
    }
    private void insert(String s)
    {
        Trie curr = root;
        for(int i = 0;i<s.length();i++)
        {
            int c = s.charAt(i) - '0';
            if(curr.child[c] == null)
                curr.child[c] = new Trie();
            curr = curr.child[c];
        }
    }
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        for(int i = 0;i<n-k+1;i++)
        {
            insert(s.substring(i,i+k));
        }
        int[] arr = new int[k];
        return check(arr,k,0);
    }
}
class Trie
{
    Trie[] child;
    public Trie()
    {
        child = new Trie[2];
    }
}