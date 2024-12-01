package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BiggestSequence_11055 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[]dp=new int[n+1];
		int[]arr=new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {
			dp[i]=arr[i];
			
			for(int j=1;j<i;j++) {
				//자신의 값이 전 값보다 커야 자신의 dp 갱신 가능
				if(arr[i]>arr[j]) {
					//배열이 1,2,1,7이라면 dp[4]의 값이 줄어들 가능성이 있기에
					//이렇게 비교를 하는 것
					dp[i]=Math.max(arr[i]+dp[j],dp[i]);
				}
			}
		}
		int max=0;
		for(int i : dp) {
			if(i>max) {
				max=Math.max(i, max);
			}
		}
		System.out.println(max);
		
	}

}
