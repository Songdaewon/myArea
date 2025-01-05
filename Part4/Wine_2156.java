package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wine_2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] w = new int[n+1];
		int[] dp= new int[n+1];
		for(int i=1;i<=n;i++) {
			w[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=w[1];
		dp[2]=w[1]+w[2];
		
		//dp[3]부터는 3가지 중 하나다
		//1.나를 뺀 앞의 놈 둘을 합한 게 더 큰가
		//2.나와 전전 놈을 합한게 더 큰가
		//3.나와 전놈을 합하는 것은 맞다. 나와 전놈을 합했으니 전전놈은 건너뛰어야 한다.
		//그러니 전전전놈을 데리고 오는 것이 맞다.
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-1], Math.max(w[i]+dp[i-2], dp[i-3] + w[i-1] + w[i]));
		}
		
		System.out.println(dp[n]);
	}

}
