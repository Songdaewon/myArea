package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Island_4963 {
	static int world[][];
	static boolean visit[][];
	//상하좌우, 대각선 파트 : 오른쪽 위, 왼쪽 위, 오른쪽 아래, 왼쪽 아래
	static int dy[] = {1,-1,0,0, 1,1,-1,-1};
	static int dx[] = {0,0,-1,1, 1,-1,1,-1};
	//2차 배열에서는 높이(y)가 앞에 있다.
	static int h, w;
	static int island=0;
	static List<Integer> result = new LinkedList<>();;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0&&h==0) break;
			
			visit = new boolean[h][w];
			world = new int [h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					world[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(world[i][j]==1&&!visit[i][j]) {
						dfs(i,j);
						island++;
					}
				}
			}
			
			result.add(island);
			island=0;
		}
		for(int i:result) {
			System.out.println(i);
		}
	}
	static void dfs(int y, int x) {
		visit[y][x] = true;
		
		for(int i=0;i<8;i++) {
			int ny = dy[i]+y;
			int nx = dx[i]+x;
			
			if(ny>=0&&nx>=0&&ny<h&&nx<w && !visit[ny][nx]&&world[ny][nx]==1) {
				dfs(ny,nx);
			}
			
		}
		
	}
}




