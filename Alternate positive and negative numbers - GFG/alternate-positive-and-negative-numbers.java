//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        
	    List<Integer> pos = new ArrayList<>();
	    List<Integer> neg = new ArrayList<>();
	    
	    for(int i:arr){
	        if(i>=0) pos.add(i);
	        else neg.add(i);
	    }
	    
	    boolean flag = true;
	    
	    
	    int a=0, b=0, ind=0;
	    
	    while(ind<arr.length){
	        if(a<pos.size()) arr[ind++] = pos.get(a++);
	        if(b<neg.size()) arr[ind++] = neg.get(b++);
	    }
	    
    }
}