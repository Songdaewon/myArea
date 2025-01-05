package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM5 {
	static int n,m;
	static boolean[] visit;
	static int[] arr;
	static int[] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[m];
		num = new int[n];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(num);
		
		dfs(0);
		System.out.println(sb);
		
	}
	static void dfs(int depth) {
		if(depth == m) { //depth와 m이 같아질 시 내용을 출력
			for(int a : arr) {
				sb.append(a+" ");
			}
			sb.append("\n");
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

