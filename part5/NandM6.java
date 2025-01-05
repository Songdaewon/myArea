package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM6 {
	static int n,m;
	static boolean[] visit;
	static int[] arr;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[m];
		num = new int[n];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(num);
		
		dfs(0);
		System.out.println(sb2);
		
	}
	static void dfs(int depth) {
		if(depth == m) { 
			for(int i=0;i<arr.length;i++) {
				if(i==0)
					sb.append(arr[i]+" ");
				else if(arr[i-1]>arr[i]) {
					sb.setLength(0);
					return;
				}
				else if(arr[i]>arr[i-1]){
					sb.append(arr[i]+" ");
				}
			}
			sb2.append(sb+"\n");
			sb.setLength(0);
			return;
		}

		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=num[i];
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}
}
