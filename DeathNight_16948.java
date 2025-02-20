package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DeathNight_16948 {
	static int n;
	static int arr[][];
	static int x1,y1, x2,y2;
	static int dx[] = {-2,-2,0,0,2,2};
	static int dy[] = {-1,1,-2,2,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());

		bfs(y1,x1);

		System.out.println(arr[y2][x2]-1);
	}
	static void bfs(int y,int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y,x});
		arr[y][x]=1;

		while(!q.isEmpty()) {
			int[] yx = q.poll();

			for(int i=0;i<6;i++) {
				int ny = yx[0]+dy[i];
				int nx = yx[1]+dx[i];

				if(ny<0||nx<0||ny>=n||nx>=n)
					continue;

				if(arr[ny][nx]==0) {
					arr[ny][nx]=arr[yx[0]][yx[1]]+1;
					q.add(new int[] {ny,nx});
				}
			}
		}
	}
}





