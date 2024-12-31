package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quit_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max=0;
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] dp = new int[n+2];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1;i<=n+1;i++) {
			dp[i]=Math.max(max, dp[i]);
			
			if( i<=n && i+t[i]<=n+1 ) {
				dp[i+t[i]] = Math.max(dp[i]+p[i], dp[i+t[i]]);
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}