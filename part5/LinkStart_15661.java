package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkStart_15661 {
	static int n;
	static int[][] s;
	static boolean visit[];
	static int min=Integer.MAX_VALUE;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		s=new int[n][n];
		visit = new boolean[n];

		for(int i=0;i<n;i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0,0);
		System.out.println(min);

	}
	static void combi(int idx, int count) {
		if(idx==n) {
			if(count>=1&&count<n) {
				diff();
			}
			return;
		}

		visit[idx]=true;
		combi(idx+1,count+1);
		visit[idx]=false;
		combi(idx+1,count);
	}
	static void diff() {
		int start =0;
		int link = 0;

		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(visit[i]&&visit[j]) {
					start+=s[i][j]+s[j][i];
				}
				else if(!visit[i]&&!visit[j]) {
					link+=s[i][j]+s[j][i];
				}
			}
		}
		int val = Math.abs(start-link);
		if(val==0) {
			System.out.println(val);
			System.exit(0);
		}

		min=Math.min(val,min);
	}

}






