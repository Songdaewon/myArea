package part7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BreakWall4_16946 {

	static int n, m;
	static char map[][];
	static int di[] = {-1, 1, 0, 0};
	static int dj[] = {0, 0, -1, 1};
	static int group[][];
	static Map<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		group = new int[n][m];
		

		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int idx = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='0' && group[i][j]==0) {
					idx++;
					bfs(i,j,idx);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='1') {
					
					int c=1;
					Set<Integer> set = new HashSet<>();
					for(int d=0;d<4;d++) {
						int ni = i + di[d];
                        int nj = j + dj[d];
						
						if(ni<0||nj<0||ni>=n||nj>=m || group[ni][nj]==0)
							continue;
						
						set.add(group[ni][nj]);
					}
					for(int key:set) {
						c+=hm.get(key);
					}
					sb.append(c%10);
				}
				else {
					sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int s,int e,int gn) {
		int count=0;
		Queue<Loc> q = new ArrayDeque<>();
		q.add(new Loc(s,e));
		group[s][e] = gn;
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			count++;
			for(int i=0;i<4;i++) {
				int ni = l.i+di[i];
				int nj = l.j+dj[i];
				
				if(ni<0||nj<0||ni>=n||nj>=m)
					continue;
				
				if(map[ni][nj]=='0'&&group[ni][nj]==0) {
					q.add(new Loc(ni,nj));
					group[ni][nj] = gn;
				}
			}
		}
		hm.put(gn, count);
	}
	static class Loc{
		int i,j;
		
		public Loc(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}
}



















