package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM3 {

	static int n,m;

	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr=new int[m];

		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if(depth==m) {
			for(int i:arr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=0;i<n;i++) {

			arr[depth]=i+1;

			dfs(depth+1);

		}

	}
}
