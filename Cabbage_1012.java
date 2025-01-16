package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cabbage_1012 {
	
	static int t,m,n,k;
	static int arr[][];
	static boolean visit[][];
	static int worm = 0;
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			visit = new boolean[n][m];
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[y][x] = 1;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==1&&!visit[i][j]) {
						dfs(i,j);
						worm++;
					}
				}
			}
			System.out.println(worm);
			worm=0;
		}
	}
	
	static void dfs(int y,int x) {
		visit[y][x]=true;
		
		for(int i=0;i<4;i++) {
			int ny = dy[i]+y;
			int nx = dx[i]+x;
			
			if(nx>=0&&ny>=0&&nx<m&&ny<n&&arr[ny][nx]==1&&!visit[ny][nx]) {
				dfs(ny,nx);
			}
		}
	}

}
