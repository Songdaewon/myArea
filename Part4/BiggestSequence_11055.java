package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BiggestSequence_11055 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n+1];
		int arr[] = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			dp[i]=arr[i];

			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(arr[i]+dp[j], dp[i]);
				}
			}
		}
		
		int max=0;
		for(int i : dp) {
			max=Math.max(max, i);
		}
		
		System.out.println(max);


	}

}
