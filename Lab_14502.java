package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab_14502 {

	public static int n, m;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] map;
	public static int[][] virusMap;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(max);
	}

	static void dfs(int wall) {
		if(wall==3) {
			bfs();
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(wall+1);
					map[i][j]=0;
				}
			}
		}
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		virusMap = new int[n][m];

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				virusMap[i][j] = map[i][j];
				if(virusMap[i][j]==2)
					q.add(new int[] {i,j});	    		
			}
		}

		while(!q.isEmpty()) {
			int temp[] = q.poll();

			for(int i=0;i<4;i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];

				if (nx >= 0&&nx < n&&ny >= 0&&ny < m&&virusMap[nx][ny] == 0) {
					virusMap[nx][ny] = 2;
					q.add(new int[]{nx, ny});
				}
			}
		}
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virusMap[i][j]==0) {
					count++;
				}
			}
		}
		max = Math.max(max, count);

	}
}
