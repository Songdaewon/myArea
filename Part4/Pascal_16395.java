package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pascal_16395 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[31][31];
		
		dp[1][1]=1;
		for(int i=2;i<=30;i++) {
			for(int j=1;j<=i;j++) {
				dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
