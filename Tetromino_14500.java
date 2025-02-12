package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino_14500 {
	static int max=Integer.MIN_VALUE;
	static int n,m;
	static int arr[][];
	static boolean visit[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n][m];
		arr = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visit[i][j]=true;
				dfs(i,j,arr[i][j],1);
				visit[i][j]=false;
			}
		}
		System.out.println(max);

	}
	
	static void dfs(int y,int x,int sum,int count) {
		if(count==4) {
			max=Math.max(sum, max);
		}
		
		for(int i=0;i<4;i++) {
			int ny = dy[i]+y;
			int nx = dx[i]+x;
			
			if(ny<0||nx<0||ny>=n||nx>=m||visit[ny][nx])
				continue;
			
			if(count==2) {
				visit[ny][nx]=true;
				dfs(y,x,sum+arr[ny][nx],count+1);
				visit[ny][nx]=false;
			}
			
			visit[ny][nx]=true;
			dfs(ny,nx,sum+arr[ny][nx],count+1);
			visit[ny][nx]=false;
		}
	}
}
