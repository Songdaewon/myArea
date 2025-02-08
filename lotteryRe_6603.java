package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lotteryRe_6603 {
	static int k;
	static int s[], arr[]=new int[6];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<String> q = new LinkedList<>();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			if(k==0)
				break;
			
			visit = new boolean[k];
			s = new int[k];
			for(int i=0;i<k;i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0);
			q.add(sb2.toString());
			sb2.setLength(0);
		}
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
	}
	static void dfs(int depth) {
		if(depth==6) {
			for(int i=0;i<6;i++) {
				if(i==0)
					sb.append(arr[i]+" ");
				else if(arr[i-1]>arr[i]) {
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
		
		for(int i=0;i<k;i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=s[i];
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}

}
