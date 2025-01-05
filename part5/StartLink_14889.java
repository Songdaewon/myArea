package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink_14889 {
	static int n;
	static int[][] s;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		visit=new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0);
		System.out.println(min);

	}
	static void combi(int idx,int count) {
		if(count==n/2) {
			diff();
			return;
		}
		//팀을 [(1, 2), (3, 4)] , [(1, 3), (2, 4)] 등으로 계속 나눠 탐색
		for(int i=idx;i<n;i++) {
			if(!visit[i]) {
				visit[i]=true;		
				combi(i+1,count+1);
				visit[i]=false;
			}
		}
	}
	static void diff() {
		int start = 0;
		int link = 0;

		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(visit[i]&&visit[j]) {
					start +=s[i][j];
					start +=s[j][i];
				}
				else if(!visit[i]&&!visit[j]) {	
					link +=s[i][j];
					link +=s[j][i];
				}
			}
		}
		int val = Math.abs(start-link);
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		min = Math.min(val, min);
	}

}
