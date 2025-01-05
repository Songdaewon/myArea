package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static int ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		v = new boolean[n];
		for(int i=0;i<n;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
		for(int i = 0; i < n; i++) {
			if(ans == 0)
				dfs(i, 1);
		}
		System.out.println(ans);
	}
	static void dfs(int start,int depth) {
		if(depth == 5) {
			ans = 1;
			return;
		}
		v[start] = true;
		for(int i : list[start]) {
			int next = i;
			if(!v[next]) {
				dfs(next, depth+1);
			}
		}
		v[start] = false;
	}
}
