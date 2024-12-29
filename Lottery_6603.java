package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lottery_6603 {
	static int n=-1;
	static boolean[] visit;
	static int[] arr;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> q = new LinkedList<>();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;

			visit = new boolean[n];
			arr = new int[6];
			num = new int[n];
			for(int i=0;i<n;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);

			dfs(0);
			q.add(sb2.toString());
			sb2.setLength(0);
		}
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

	static void dfs(int depth) {
		if(depth == 6) { 
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
