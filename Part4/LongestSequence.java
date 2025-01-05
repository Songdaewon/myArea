package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSequence {
	public static void main(String[] args) throws IOException{

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int n = Integer.parseInt(br.readLine());
	     int[] dp = new int[n+1];
	     int[] arr = new int[n+1];
	     StringTokenizer st =new StringTokenizer(br.readLine());
	     
	     for(int i=1;i<=n;i++) {
	    	 dp[i]=1;
	    	 arr[i]=Integer.parseInt(st.nextToken());
	     }
	     
	     int count=1;
	     for(int i=2;i<=n;i++) {
	    	 for(int j=1;j<i;j++) {
	    		 if(arr[i]>arr[j]&&dp[i]<=dp[j]) {
	    			 dp[i]=dp[j]+1;
	    		 }
	    	 }
	    	 count=Math.max(count, dp[i]);
	     }
	     System.out.println(count);
	}
}
