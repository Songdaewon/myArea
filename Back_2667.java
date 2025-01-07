package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Back_2667 {
	static int[][] house;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static List<Integer> result;
	static int cnt, n;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result = new LinkedList<>();
		n = Integer.parseInt(br.readLine());
		house = new int[n][n];
		visit = new boolean[n][n];
		cnt = 1;
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				house[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(house[i][j]==1&&!visit[i][j]) {
					dfs(i,j);
					result.add(cnt);
					cnt = 1;
				}
				
			}
		}
		
		System.out.println(result.size());
		for(int i:result) {
			System.out.println(i);
		}
		
	}
	static void dfs(int x,int y) {
		visit[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx>=0&&ny>=0&&nx<n&&ny<n&&!visit[nx][ny]&&house[nx][ny]==1) {
				cnt++;
				dfs(nx,ny);
			}
		}
	}

}
