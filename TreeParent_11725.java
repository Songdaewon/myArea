import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeParent_11725 {
	
	static int n;
	static int parent[];
	static boolean visit[];
	static ArrayList<Integer> list[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n+1];
		parent = new int[n+1];
		list = new ArrayList[n+1];
		
		for(int i=0;i<n+1;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		for(int i=2;i<parent.length;i++) {
			System.out.println(parent[i]);
		}
	}
	static void dfs(int v) {
		visit[v]=true;
		for(int i:list[v]) {
			if(!visit[i]) {
				parent[i]=v;
				dfs(i);
			}
		}
	}
}








