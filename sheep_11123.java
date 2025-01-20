package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sheep_11123 {
	static int n,n1,n2;
	static int arr[][];
	static boolean visit[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,-1,1};
	static int sheep=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			arr = new int[n1][n2];
			visit = new boolean[n1][n2];
			
			for(int i=0;i<n1;i++) {
				String str = br.readLine();
				for(int j=0;j<n2;j++) {
					if(str.charAt(j)=='#') {
						arr[i][j]=1;
					}
				}
			}
			
			for(int i=0;i<n1;i++) {
				for(int j=0;j<n2;j++) {
					if(!visit[i][j]&&arr[i][j]==1) {
						dfs(i,j);
						sheep++;
					}
				}
			}
			System.out.println(sheep);
			sheep=0;
		}
	}
	static void dfs(int y,int x) {
		visit[y][x]=true;
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(nx<0||ny<0||nx>=n2||ny>=n1||visit[ny][nx]||arr[ny][nx]==0) 
				continue;
			
			dfs(ny,nx);
		}
	}

}









