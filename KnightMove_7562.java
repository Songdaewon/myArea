package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightMove_7562{

	static int x1,y1,x2,y2,b;
	static int board[][];
	static boolean visit[][];
	static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int dy[] = {2, 1, -1, -2, -2, -1, 1, 2};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-->0) {
			b = Integer.parseInt(br.readLine());
			board = new int [b][b];
			visit = new boolean[b][b];

			StringTokenizer st = new StringTokenizer(br.readLine());
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			
			bfs();

			sb.append(board[y2][x2]).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y1, x1});
		visit[y1][x1] = true;

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[1];
			int ny = now[0];
			
			for(int i=0;i<8;i++) {
				int X = nx+dx[i];
				int Y = ny+dy[i];
				
				if(X<0||Y<0||X>=b|Y>=b) continue;
				
				if(!visit[Y][X]) {
					q.add(new int[] {Y,X});
					board[Y][X] = board[ny][nx]+1;
					visit[Y][X] = true;
				}
			}
			
		}
	}
}





