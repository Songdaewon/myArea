package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsNum_11724 {
	static int n,m;
	static boolean v[];
	static int arr[][];
	static int result=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		v = new boolean[n+1];
		arr = new int[n+1][n+1];
	
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a][b]=arr[b][a]=1;
		}
		
		for(int i=0;i<n;i++) {
			if(!v[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(sb);
		System.out.println(result);

	}
	static void dfs(int node) {
		v[node]=true;
		sb.append(node+" ");
		for(int i=0;i<n;i++) {
			if(!v[i]&&arr[node][i]==1) {
				dfs(i);
			}
			
		}
	}
}
