package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpJump_14248 {
	
	static int n, ai;
	static int arr[];
	static boolean visit[];
	static int move = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		visit = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ai = Integer.parseInt(br.readLine());
		
		dfs(ai-1);
		System.out.println(move);
	}
	static void dfs(int v) {
		visit[v]=true;
		
		int vr = v+arr[v]; 
		int vl = v-arr[v];
		
		if(vr<n&&!visit[vr]) {
			dfs(vr);
			move++;
		}
		if(vl>=0&&!visit[vl]) {
			dfs(vl);
			move++;
		}
	}
}



