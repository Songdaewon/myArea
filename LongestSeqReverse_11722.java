package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSeqReverse_11722 {

	public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n+1];
		int arr[] = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			dp[i]=1;
			arr[i]=Integer.parseInt(st.nextToken());
		}

		int count=1;
		for(int i=n-1;i>=1;i--) {
			for(int j=n;j>i;j--) {
				if(arr[i]>arr[j]&&dp[i]<=dp[j]) {
					dp[i]=dp[j]+1;
				}
			}
			count=Math.max(count, dp[i]);
		}
		System.out.println(count);
    }

}
