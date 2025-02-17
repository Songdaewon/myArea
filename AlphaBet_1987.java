package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlphaBet_1987 {
	static int r,c,max=0;
	static int arr[][];
	static boolean visit[]=new boolean[26];
	static int dy[] = {1,-1,0,0}, dx[] = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[r][c];
		
		for(int i=0;i<r;i++) {
			String str = br.readLine();
			for(int j=0;j<c;j++) {
				arr[i][j] = str.charAt(j)-'A';
			}
		}
		
		dfs(0,0,1);
		System.out.println(max);
	}
	static void dfs(int y,int x,int move) {
		visit[arr[y][x]]=true;
		max = Math.max(max, move);
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0||nx<0||ny>=r||nx>=c||visit[arr[ny][nx]])
				continue;
			
			dfs(ny,nx,move+1);

		}
		visit[arr[y][x]]=false; //재귀로 복귀했을 때 다시 이동하기 위하여
	}
}




