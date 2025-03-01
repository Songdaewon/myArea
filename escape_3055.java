package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class escape_3055 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int r, c;
	static Character[][] map;
	static int[][] count;
	static int answer=Integer.MAX_VALUE;
	public static Queue<int[]> q = new LinkedList<>();
	public static Queue<int[]> water = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new Character[r][c];
		count = new int[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j]=='S') { //고슴도치 시작점
					q.add(new int[]{i,j,0}); //좌표와 이동시간
				}else if(map[i][j]=='*'){
					water.add(new int[]{i,j});
				}
			}
		}

		bfs();
		System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			//물의 이동
			int l = water.size();
			for(int i=0;i<l;i++) {
				
				int[] t = water.poll();
				int x = t[0];
                int y = t[1];
				
				for(int d=0;d<4;d++) {
					
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx>=0&&ny>=0&&nx<r&&ny<c && map[nx][ny]=='.') {
						map[nx][ny] = '*';
						water.add(new int[]{nx,ny});
					}
				}
			}

			//고슴도치의 이동
			l = q.size();
			for(int i=0;i<l;i++) {
				
				int[] t = q.poll();
				int x = t[0];
                int y = t[1];
                int time = t[2];
                
				for(int d=0;d<4;d++) {
					
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx>=0&&ny>=0&&nx<r&&ny<c) {
						if(map[nx][ny]=='D') {
							answer = Math.min(answer, time+1);
							return;
						}
						else if(map[nx][ny]=='.') {
							map[nx][ny] = 'S';
							q.add(new int[] {nx,ny,time+1});
						}
					}
				}
			}
		}
	}
}
