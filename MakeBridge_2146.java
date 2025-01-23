package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MakeBridge_2146 {

	static int n;
	static int map[][];
	static boolean visit[][];
	static int bridge=0;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int isNum=2;
	static int min = 200;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];

		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//우선 dfs로 섬들을 구분시킨다.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j]&&map[i][j]==1) {
					dfs(i,j);
					isNum++;
				}
			}
		}

		
		//그 다음 bfs로 다리의 최소길이 탐색
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]>1) {
					bfs(i,j,map[i][j]);
				}
			}
		}
		System.out.println(min);
	}
	static void bfs(int y,int x,int num) {
		Queue<Integer[]> q = new LinkedList<>();
		visit = new boolean[n][n];
		visit[y][x] = true;
		q.add(new Integer[] {y,x,0});

		while(!q.isEmpty()) {
			Integer temp[] = q.poll();
			int nowy = temp[0];
			int nowx = temp[1];
			int count = temp[2];

			//현재 위치가 바다가 아니고, 새로운 섬을 발견했다면 min 갱신
			if(map[nowy][nowx]!=0&&map[nowy][nowx]!=num) {
				min = Math.min(min, count-1);
			}
			if(count>min)
				return;

			for(int i=0;i<4;i++) {
				int ny = nowy+dy[i];
				int nx = nowx+dx[i];   

				if(nx<0||ny<0||nx>=n||ny>=n||visit[ny][nx])
					continue;
				//섬의 테두리 즉, 바로 옆이 바다인 곳을 찾고, 건너야 함
				if(map[ny][nx]==num)
					continue;

				q.add(new Integer[] {ny,nx,count+1});
				visit[ny][nx]=true;
			}
		}
	}

	static void dfs(int y,int x) {
		visit[y][x]=true;
		map[y][x]=isNum;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(nx<0||ny<0||nx>=n||ny>=n||map[ny][nx]==0||visit[ny][nx])
				continue;

			dfs(ny,nx);
		}
	}
}







