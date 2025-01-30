package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NeedFriend_21736 {
	static int n,m;
	static char arr[][];
	static boolean visit[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	static int x,y;
	static int friend=0;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new char[n][m];
        visit = new boolean[n][m];
        
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	for(int j=0;j<m;j++) {
        		arr[i][j] = str.charAt(j);
        		if(arr[i][j]=='I') {
        			y=i;
        			x=j;
        		}
        	}
        }
        dfs(y,x);
        
        if(friend==0) {
        	System.out.println("TT");
        }
        else {
        	System.out.println(friend);
        }
	}
	static void dfs(int y,int x) {
		visit[y][x]=true;
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny>=0&&nx>=0&&ny<n&&nx<m&&!visit[ny][nx]) {
				if(arr[ny][nx]=='O') {
					dfs(ny,nx);
				}
				else if(arr[ny][nx]=='X') {
					continue;
				}
				else if(arr[ny][nx]=='P') {
					friend++;
					dfs(ny,nx);
				}
			}
		}
	}
}









