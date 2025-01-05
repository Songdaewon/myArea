package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM {
	//준내 어렵다
	static int n,m;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[m];
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
			if(!visit[i]) { //작동을 안하고 넘어가면 i와 depth에 차가 생김
				visit[i]=true;
				arr[depth]=i+1;
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}

}
