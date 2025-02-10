package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14225 {
	static int[] num = new int[20];
	static int n; // 정수의 개수
	static boolean visit[];
	static int[] answer;
	static int max=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n=Integer.parseInt(br.readLine());
		visit=new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
			max+=num[i];
		}
		answer = new int[max+2];
		
		//1. dfs로 수열에서 가능한 부분 수열의 합을 인덱스로 사용하여 1을 저장
		dfs(0,0);
		for (int i = 1; i < answer.length; i++) {
			//2. dfs로 부분 수열의 합인 인덱스는 1로 처리했기에 가장 먼저 0인 인덱스가 정답
			if (answer[i] == 0) { 
				System.out.println(i);
				break;
			}
		}
	}
	
	private static void dfs(int depth, int sum) {
		if(depth==n) {
			answer[sum]=1;
			return;
		}
		dfs(depth + 1, sum + num[depth]); 
		dfs(depth + 1, sum);

	}
}





