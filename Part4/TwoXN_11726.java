package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoXN_11726 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n=3일시 1과 2의 경우의 수를 합친 것
		//4일시 3과 2의 경우의 수를 합친 것이다.
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[0]=dp[1]=1;

		for(int i=2;i<=n;i++) {
			dp[i]=(dp[i-2]+dp[i-1])%10007;
		}
		
		System.out.println(dp[n]);
	}
}
