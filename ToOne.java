package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToOne {
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[0]=dp[1]=-1;
		System.out.println(check(n)); //재귀함수 뒤지게 어렵네
	}

	public static int check(int n) {

		if(dp[n]==-1) {
			return 0;
		}
		if(dp[n]==0) {
			if(n%6==0) {
				dp[n] = Math.min(check(n-1), Math.min(check(n/2), check(n/3)))+1;
			}
			else if(n%3==0) {
				dp[n] = Math.min(check(n/3), check(n-1))+1;
			}
			else if(n%2==0) {
				dp[n] = Math.min(check(n/2), check(n-1))+1;
			}
			else {
				dp[n]= check(n-1)+1;
			}
			
		}
		return dp[n];
	}
}
