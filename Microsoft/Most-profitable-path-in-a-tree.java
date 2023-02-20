class Solution {
    static class Edge{
        int vtc;
        int nbr;
        int amt;
        Edge(int vtc,int nbr,int amt){
            this.vtc=vtc;
            this.nbr=nbr;
            this.amt=amt;
        }
    }
    static class Pair{
        int nd;
        int time;
        int income;
        Pair(int nd,int time,int income){
            this.nd=nd;
            this.time=time;
            this.income=income;
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        //Let's make  a Graph First

        //The graph stores the node its neighbour and the weight
        ArrayList<Edge>[] graph=new ArrayList[amount.length];
        for(int i=0;i<amount.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1],amount[i]));
            graph[edges[i][1]].add(new Edge(edges[i][1],edges[i][0],amount[i]));
        }

        //Now we want to move Bob to the top so we move that via dfs 
        boolean[] visited=new boolean[amount.length];
        //What we do here is that we store the path in a hashmap representing node and the time it reaches the node
        //For first node the node is bob and time is 0
        HashMap<Integer,Integer> map=new HashMap<>();

        dfs(graph,bob,0,visited,map,0);

        System.out.println(map);

        //Lets store the max value right now as Integer.MIN_VALUE
        int ans=Integer.MIN_VALUE;


        //Now we use BFS for traversing the Alice

        //We create a Pair Class for storing the node,time and the income
        //We create the root Pair and a queue
        visited=new boolean[amount.length];
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(0,0,0));

        while(q.size()>0){
            Pair rm=q.remove();
            int node=rm.nd;
            visited[node]=true;
            int time=rm.time;
            int income=rm.income;
            //the node is not traversed by Bob
            if(map.get(node)==null){
                income+=amount[node];
            }
            else{
                //the node is traversed by Alice before
                if(time<map.get(node)){
                    income+=amount[node];
                }
                //the node is traversed at the same time
                else if(time==map.get(node)){
                    income+=amount[node]/2;
                }
                else{
                    //the node is traversed later
                    income+=0;
                }
            }
            //if leaf node,find the answer
            if(node!=0 && graph[node].size()==1){
                ans=Math.max(ans,income);
            }
            //add all the edges to queue
            for(Edge e:graph[node]){
                if(visited[e.nbr]==false){
                    q.add(new Pair(e.nbr,time+1,income));
                }
            }
        }


        return ans;
    }
    public static boolean dfs(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,HashMap<Integer,Integer> map,int time){
        map.put(src,time);
        if(src==dest){
            return true;
        }
        visited[src]=true;

        for(Edge e:graph[src]){
            if(visited[e.nbr]==false){
                boolean f=dfs(graph,e.nbr,dest,visited,map,time+1);
                if(f==true){
                    return true;
                }
            }
        }
        map.remove(src);
        return false;
    }
}
