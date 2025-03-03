package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MovingMaze_16954 {

	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
	static char[][] map = new char[8][8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<8;i++) 
			map[i] = br.readLine().toCharArray();
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(7,0));
		
		while(!q.isEmpty()) {
			int size = q.size();
			boolean visit[][] = new boolean[8][8];
			
			while(size-->0) {
				Point p = q.poll();
				if(p.x==0&&p.y==7) {
					System.out.println(1);
					return;
				}
				if(map[p.x][p.y]=='.') {
					for(int d=0;d<9;++d) {
						int nx = dx[d]+p.x;
						int ny = dy[d]+p.y;
						if(nx>=0&&ny>=0&&nx<8&&ny<8 && !visit[nx][ny] && map[nx][ny]=='.') {
							visit[nx][ny]=true;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
			moveWalls();
		}
		System.out.println(0);
	}
	
	static void moveWalls() {
		for(int i=6;i>=0;i--) {
			for(int j=0;j<8;j++) {
				map[i+1][j]=map[i][j];
			}
		}
		
		for(int i=0;i<8;i++) {
			map[0][i]='.';
		}
	}
	
	static class Point {
		int x;
		int y;

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}
