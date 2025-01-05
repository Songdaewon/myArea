package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxDiff_10819 {
	static int n;
	static boolean[] visit;
	static int[] arr;
	static int[] num;
	static int max=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n];
		arr = new int[n];
		num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}

		dfs(0);
		System.out.println(max);

	}
	static void dfs(int depth) {
		if(depth == n) { 
			
			int sum=0;
			for(int i=0;i<n-1;i++) {
				sum += Math.abs(arr[i]-arr[i+1]);
			}
			max=Math.max(max, sum);
			return;
		}

		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=num[i];
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}
}
