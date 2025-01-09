package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze_2178 {

	static int n,m;
	static int maze[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	static boolean visit[][];
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m];
		visit[0][0] = true;

		maze = new int[n][m];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				maze[i][j] = str.charAt(j)-'0';
			}
		}

		bfs(0,0); 
		System.out.println(maze[n-1][m-1]);
	}
	static void bfs(int x,int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});

		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX>=0&&nextY>=0&&nextY<n&&nextX<n && !visit[nextX][nextY]&&maze[nextX][nextY]==1) {
					q.add(new int[] {nextX, nextY});
					maze[nextX][nextY] = maze[nowX][nowY]+1;
					visit[nextX][nextY] = true;
				}
			}
		}
	}

}


