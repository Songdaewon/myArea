package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoXN2_11727 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n=4일시 3경우의 수 + 2의 경우의 수 * 2 
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[0]=dp[1]=1;

		for(int i=2;i<=n;i++) {
			dp[i]=(dp[i-1] + dp[i-2] * 2)%10007;
		}

		
		System.out.println(dp[n]);
	}

}
