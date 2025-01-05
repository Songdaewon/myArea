package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB_1149 {
	/*
	n번 집의 색은 n-번 집의 색과 같지 않아야 한다.
	처음에는 맨 밑의 수 중 가장 작은 수를 찾고 위로 올라가는 방식인 줄 알았으니
	모든 뿌리의 경우의 수를 고려해야 한다.
	즉 [n][0] += Math.min( [n-1][1],[n-1][2] ); n++; 이런 식으로 
	*/
	static int[][] dp;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp=new int[n][3];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {	
				dp[i][j++]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<n;i++) {
			dp[i][0]+=Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1]+=Math.min(dp[i-1][2], dp[i-1][0]);
			dp[i][2]+=Math.min(dp[i-1][1], dp[i-1][0]);
		}
		System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
		
		
	}

}
