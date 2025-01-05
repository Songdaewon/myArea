package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM4 {
	static boolean check=true;
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		dfs(0);
		System.out.println(sb2);
	}
	static void dfs(int depth) {
		if(depth==m) {
			for(int i=0;i<arr.length;i++) {
				if(i==0) sb.append(arr[i]+" ");
				else if(arr[i]>=arr[i-1]) {
					sb.append(arr[i]+" ");
				}
				else if(arr[i]<arr[i-1]) {
					check=false;
					sb.setLength(0);
					break;
				}
			}
			if(check) {
				sb2.append(sb+"\n");
				sb.setLength(0);
			}
			else {
				check=true;
			}
			return;
		}

		for(int i=0;i<n;i++) {
			arr[depth]=i+1;
			dfs(depth+1);
		}
	}
}
