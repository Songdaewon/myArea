package part5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AllPermutation_10974{
	
	static int n;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[n];
		dfs(0);
		System.out.println(sb);
	}
	static void dfs(int depth) {
		if(depth == n) { 
			for(int a : arr) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=i+1;
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}

}