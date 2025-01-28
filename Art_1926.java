package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Art_1926 {
	static int n,m;
	static int arr[][];
	static boolean visit[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	static int artN = 0; //그림 개수
	static int artL = 0; //그림 넓이
	static int artM = 0; //가장 큰 그림

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visit = new boolean[n][m];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visit[i][j]&&arr[i][j]==1) {
					artN++;
					dfs(i,j);
					if(artL>0) {
						artM = Math.max(artM, artL);
						artL=0;
					}
				}
			}
			
		}
		System.out.println(artN);
		System.out.println(artM);
	}
	static void dfs(int y,int x) {
		visit[y][x]=true;
		artL++;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(nx>=0&&ny>=0&&ny<n&&nx<m&&!visit[ny][nx]&&arr[ny][nx]==1) {
				visit[ny][nx]=true;
				dfs(ny,nx);
			}
		}
	}
}







