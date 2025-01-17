import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724 {
	static int n,m;
	static boolean visit[];
	static int arr[][];
	static int l=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];

		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;
		}
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				dfs(i);
				l++;
			}
		}

		System.out.println(l);
	}

	static void dfs(int v) {
		if(visit[v]) return;
		
		visit[v]=true;

		for(int i=1;i<=n;i++) {
			if(arr[v][i]==1) {
				dfs(i);
			}
		}
	}
}










