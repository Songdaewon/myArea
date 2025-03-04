package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LaserConnect_6087 {

	static int w, h;
	static char[][] map;
	static Node[] target = new Node[2];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new char[h][w];


		for (int i = 0, idx = 0; i < h; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
			for(int j=0;j<w;j++) {
				if(map[i][j]=='C')
					target[idx++] = new Node(i,j,-5,-1);
			}
		}
		
		System.out.println(bfs(target[0]));
	}
	
	static int bfs(Node start) {
		int min = Integer.MAX_VALUE;
		Node goal = target[1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		int visit[][][] = new int[4][h][w];
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<h;j++) {
				Arrays.fill(visit[i][j], Integer.MAX_VALUE);
			}
		}
		
		q.add(start);
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			//목적지에 도달시
			if (now.x == goal.x && now.y == goal.y) {
                min = Math.min(min, now.mir);
                continue;
            }
			
			for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nmir = now.dir==i ? now.mir : now.mir+1;
                
                if(nx<0||ny<0||nx>=h||ny>=w || map[nx][ny]=='*' || Math.abs(now.dir-i)==2) 
                	continue;
                
                if(visit[i][nx][ny]>nmir) {
                	q.add(new Node(nx,ny,i,nmir));
                	visit[i][nx][ny] = nmir;
                }
                
			}
		}
		
		return min;
	}
	
	static class Node implements Comparable<Node>{
		int x, y, dir, mir;

		public Node(int x,int y,int dir,int mir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mir=mir;
		}

		@Override
        public int compareTo(Node o) {
            return this.mir - o.mir;
        }
	}

}
