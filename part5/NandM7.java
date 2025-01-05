package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM7 {
	static int n;
	static int m;
	static int arr[];
	static int num[];
	static StringBuilder sb= new StringBuilder();;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		num=new int[n];
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
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
			arr[depth]=num[i];
			dfs(depth+1);
		}
	}

}
