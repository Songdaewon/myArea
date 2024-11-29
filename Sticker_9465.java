package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker_9465 {
	//dp[0][i]=Math.max(dp[1][i-2], dp[1][i-1])+s[0][i];
	//일반적으로 대각선끼리 인접한 2개의 값을 더한 게 더 큰지
	//그냥 2칸 전 대각선에 있는 값이 터 큰지 비교
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		

		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s[][] = new int[2][n+1];
			int dp[][] = new int[2][n+1];
			int z=1;
			while(st1.hasMoreTokens()&&st2.hasMoreTokens()) {
				s[0][z]=Integer.parseInt(st1.nextToken());
				s[1][z++]=Integer.parseInt(st2.nextToken());
			}
			
			dp[0][1]=s[0][1];
			dp[1][1]=s[1][1];
			
			for(int i=2;i<=n;i++) {
				dp[0][i]=Math.max(dp[1][i-2], dp[1][i-1])+s[0][i];
				dp[1][i]=Math.max(dp[0][i-2], dp[0][i-1])+s[1][i];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

}
