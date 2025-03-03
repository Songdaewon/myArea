package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark_16236 {
	static int n;
	static int map[][], dis[][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int size = 2; // 상어 크기
	static int sx=-1; // 상어의 X 
	static int sy=-1; // 상어의 Y 

	static int eat = 0; // 물고기 먹은 횟수
	static int cnt = 0; // 이동한 횟수

	static int minX, minY, minDis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0; // 상어가 있었던 위치 나중에 이동할 수 있음
				}
			}
		}
		

		while(true) {
			dis = new int[n][n];
			minX = Integer.MAX_VALUE; 
			minY = Integer.MAX_VALUE; 
			minDis = Integer.MAX_VALUE;

			bfs(sx,sy);

			if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				eat++; 
				map[minX][minY] = 0; 
				sx = minX; 
				sy = minY; 
				cnt += dis[minX][minY]; 

				if(eat == size) {
					size++; 
					eat = 0; 
				}
			}
			else { 
				break;
			}
		}
		System.out.println(cnt);
	}

	static void bfs(int x,int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();

			for(int d=0;d<4;d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				//크기가 같다면 먹을 순 없어도 지나갈 수는 있음 && 방문한 적 없는 곳
				if(nx>=0&&ny>=0&&nx<n&&ny<n && map[nx][ny]<=size && dis[nx][ny]==0) {
					dis[nx][ny] = dis[p.x][p.y] + 1;

					//먹을 수 있다면
					if(map[nx][ny]!=0&&map[nx][ny]<size) {
						//거리 따지기
						if(minDis>dis[nx][ny]) {
							minDis = dis[nx][ny];
							minX = nx; 
							minY = ny;
						}
						else if(minDis == dis[nx][ny]) {
							if (minX > nx || (minX == nx && minY > ny)) {
								minX = nx;
								minY = ny;
							}
						}
					}
					
					q.add(new Pos(nx,ny));
				}
			}
		}
	}

	static class Pos{
		int x, y;

		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}







