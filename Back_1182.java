package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1182 {
	static int[] num;
	static int n; // 정수의 개수
	static int s; // 정수의 합
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());
		num=new int[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}

		dfs(0,0);
		//s==0이면, dfs가 0에서 시작하기에 아무것도 안더해도 0이 나와 answer가 무조건 1이됨
		if(s==0)
			System.out.println(answer-1);
		else
			System.out.println(answer);
	}

	private static void dfs(int depth, int sum) {
		if(depth==n) {
			if(sum==s)
				answer++;
			return;
		}

		dfs(depth+1,sum+num[depth]);
		dfs(depth+1,sum);
	}
}




