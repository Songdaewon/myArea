package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo_1309 {
	static int mod = 9901;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][]dp = new long[n+1][3];
		dp[1][0]=dp[1][1]=dp[1][2]=1;
		
		for(int i=2;i<=n;i++) {
			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%mod;
			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
			dp[i][2]=(dp[i-1][0]+dp[i-1][1])%mod;
		}
		long ans = (dp[n][0] + dp[n][1] + dp[n][2]) % mod;
		System.out.println(ans);
	}

}
