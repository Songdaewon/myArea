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
		//문제 정리 : 걍 처음 부터 시작해서 나랑 앞의 놈을 더한게 더 큰지 걍 앞에 놈이 더 큰지를 비교하면 됨
		//ㅅㅂ문제 이해부터가 안됐네 내 30분이 무너졌어
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
	
	static int re(int n) {
		
		if(dp[n]==null) {
			dp[n]=Math.max(re(n-1)+arr[n], arr[n]);
			
			max=Math.max(max, dp[n]);
		}
		
		return dp[n];
		
	}
}
