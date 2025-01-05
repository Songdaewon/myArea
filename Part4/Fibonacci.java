package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
static int dp[];
	public static void main(String[] args) throws IOException {
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	     int n = Integer.parseInt(bf.readLine());
	     dp = new int[46];
	     dp[0]=0;
	     dp[1]=dp[2]=1;
	     
	     for(int i=3;i<=45;i++) {
	    	 dp[i]=dp[i-1]+dp[i-2];
	     }
	     
	     System.out.println(dp[n]);
	     
	}

}
