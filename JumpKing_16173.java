package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpKing_16173 {
	
	static int n;
	static int arr[][];
	static boolean visit[][];
	static int move=-2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(dfs(0,0)) {
			System.out.println("HaruHaru");
		}
		else {
			System.out.println("Hing");
		}

	}
	static boolean dfs(int y,int x) {
		
		if(y<0||x<0||x>=n||y>=n||visit[y][x])
			return false;
		
		visit[y][x]=true;
		move = arr[y][x];
		if(move==-1) {
			return true;
		}
		else if(move==0) {
			return false;
		}

		int ny = move+y;
		int nx = move+x;
		
		//오른쪽
		if(dfs(y,nx)) {
			return true;
		}
		//아래
		if(dfs(ny,x)) {
			return true;
		}
		
		return false;
	}
}




