package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakWall_2206 {
	static int n,m, min = 1;
	static char map[][];
	static boolean visit[][][];
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visit = new boolean[n][m][2];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0,0,1,false));
		visit[0][0][0]=true;
		
		while(!q.isEmpty()) {
			Loc now = q.poll();
			
			if(now.i==n-1&&now.j==m-1) {
				System.out.println(now.cnt);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int ni = now.i+di[i];
				int nj = now.j+dj[i];
				
				if(ni<0||nj<0||ni>=n||nj>=m) continue;
				
				if(map[ni][nj]=='0') {
					if(!now.destroyed&&!visit[ni][nj][0]) {
						q.add(new Loc(ni,nj,now.cnt+1,false));
						visit[ni][nj][0]=true;
					}
					else if(now.destroyed&&!visit[ni][nj][1]) {
						q.add(new Loc(ni,nj,now.cnt+1,true));
						visit[ni][nj][1]=true;
					}
				}
				else if(map[ni][nj]=='1') {
					if(!now.destroyed) {
						q.add(new Loc(ni,nj,now.cnt+1,true));
						visit[ni][nj][1]=true;
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	
	static class Loc{
        int i;
        int j;
        int cnt;
        boolean destroyed;

        public Loc(int i, int j, int cnt, boolean d) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }
}











