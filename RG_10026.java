package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RG_10026 {
	static int n, areaN=0, areaRG=0;
	static char normal[][];  //일반인
	static char rg[][];      //적록색약인
	static boolean visit[][];
	static char curColor;

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		normal = new char[n][n];
		rg = new char[n][n];

		for(int i=0;i<n;i++) {
			String str=br.readLine();
			for(int j=0;j<n;j++) {
				normal[i][j]=str.charAt(j);
				rg[i][j]=str.charAt(j);

				if(rg[i][j]=='G') //초록,빨강을 구분 못하니 빨강으로 통일
					rg[i][j]='R';
			}
		}
		
		visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j]) {
					bfs(i,j,normal[i][j],normal);
					areaN++;
				}
			}
		}
		
		visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j]) {
					bfs(i,j,rg[i][j],rg);
					areaRG++;
				}
			}
		}
		
		System.out.print(areaN);
		System.out.print(' ');
		System.out.println(areaRG);

	}

	private static void bfs(int i,int j,char color,char[][] map) {
		visit[i][j]=true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i,j});

		while(!q.isEmpty()) {
			int[] xy = q.poll(); 
			for(int d=0;d<4;d++) {

				int nx = dx[d]+xy[0];
				int ny = dy[d]+xy[1];

				if(nx<0||ny<0||nx>=n||ny>=n)
					continue;

				if(!visit[nx][ny]&&color==map[nx][ny]) {
					q.add(new int[]{nx,ny});
					visit[nx][ny]=true;
				}
			}
		}
	}

}












