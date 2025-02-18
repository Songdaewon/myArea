package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuitRe_14501 {
	static int n, max;
	static int t[], p[], dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		t = new int[n+1];  //상담에 소요되는 일의 수
		p = new int[n+1];  //상담하고 받는 돈
		dp = new int[n+2]; //n+1일때까지 돈을 벌 수 있음
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n+1;i++) {
			dp[i] = Math.max(dp[i], max);
			//예제 입력4에 대하여
			//후반부에 나오는 8일의 3 30에 정확히 멈추는 경우의 수는 업고 항상 7일의 2 20에서 멈춘다.
			//이는 7일을 건너뛰고 8일의 일을 수락하여 더 큰 이득을 취한 것.
			//그러므로 위의 코드는 7일까지 번 돈을 8일에 그대로 옳긴 행위이다.
			
			if(i<=n && i+t[i]<=n+1) {
				dp[i+t[i]]=Math.max(p[i]+dp[i], dp[i+t[i]]);
				//1일에 3 20과
				//2일에 2 10이 있다고 치자, 그럼 각각 4일에 버는 돈은 20과 10이다.
				//그럼 처음 dp[4]에는 20이 들어가지만 이후 더 작은 10이 들어갈 수 있기에
				//위와 같이 max함수를 이용하여 최대값을 구분짓는다.
			}
			max = Math.max(dp[i], max);
			System.out.println(max);
		}
		System.out.println();
		System.out.println(max);
		
	}

}






