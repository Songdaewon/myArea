package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM8 {
	static int n;
	static int m;
	static int arr[];
	static int num[];
	static StringBuilder sb= new StringBuilder();
	static StringBuilder sb2= new StringBuilder();
	
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
		System.out.println(sb2);
	}
	static void dfs(int depth) {
		if(depth==m) {
			for(int i=0;i<m;i++) {
				if(i==0) sb.append(arr[i]+" ");
				else if(arr[i]<arr[i-1]) {
					sb.setLength(0);
					return;
				}
				else {
					sb.append(arr[i]+" ");
				}
			}
			sb2.append(sb+"\n");
			sb.setLength(0);
			return;
		}

		for(int i=0;i<n;i++) {
			arr[depth]=num[i];
			dfs(depth+1);
		}
	}

}
