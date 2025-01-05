package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum_1912 {
	static Integer[] dp;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp = new Integer[n];
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = dp[0] = arr[0];
		
		re(n-1);
		System.out.println(max);
		
	}
	//이전까지의 모든 합 vs 현재합 중 더 큰거 고르기
	static int re(int n) {
		
		if(dp[n]==null) {
			dp[n]=Math.max(re(n-1)+arr[n], arr[n]);
			
			max=Math.max(max, dp[n]);
		}
		
		return dp[n];
		
	}
}
