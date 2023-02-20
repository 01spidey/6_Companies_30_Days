class Solution {
    public boolean canFinish(int n, int[][] p) {
        int a[]=new int[n];
        List<List<Integer>> nm=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            nm.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++)
        {
            nm.get(p[i][1]).add(p[i][0]);
        }
        for(int i=0;i<n;i++)
        {
            if(!task(nm,a,i))
                return false;
        }
        return true;
    }
    public boolean task(List<List<Integer>> nm, int a[], int k)
    {
        if(a[k]==1)
            return true;
        if(a[k]==2)
            return false;
        a[k]=2;
        for(int i:nm.get(k))
        {
            if(!task(nm,a,i))
                return false;
        }
        a[k]=1;
        return true;
    }
}
