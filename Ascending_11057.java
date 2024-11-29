package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascending_11057 {
	static int mod=10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[n+1][10];
		
		for(int i=0;i<=9;i++) {
			dp[0][i]=1;
		}

		for(int i=1;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=j;k<=9;k++) {
					dp[i][j]+=dp[i-1][k]%mod;
				}
			}
		}
		System.out.println(dp[n][0]%mod);
	}

}
