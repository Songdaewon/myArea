package part7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RockGroup_12886 {
	static int a,b,c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(a,b,c));
	}
	
	static int bfs(int a, int b, int c) {
		
		//기본 법칙
		if((a + b + c) % 3 != 0) return 0;
		
		Queue<Stone> q = new LinkedList<>();
		boolean[][] check = new boolean[1501][1501];
		
		q.add(new Stone(a,b,c));
		check[a][b] = true;
		
		while(!q.isEmpty()) {
			Stone s = q.poll();
			
			a = s.a;
			b = s.b;
			c = s.c;
			
			if(a==b&&b==c)
				return 1;
			
			if(a!=b) {
				int na = a>b ? a-b : a+a;
				int nb = a>b ? b+b : b-a;
				
				if(!check[na][nb]) {
					q.add(new Stone(na,nb,c));
					check[na][nb] = true;
				}
			}
			
			if(b!=c) {
				int nb = b>c ? b-c : b+b;
				int nc = b>c ? c+c : c-b;
				
				if(!check[nb][nc]) {
					q.add(new Stone(a,nb,nc));
					check[nb][nc] = true;
				}
			}
			
			if(a!=c) {
				int na = a>c ? a-c : a+a;
				int nc = a>c ? c+c : c-a;
				
				if(!check[na][nc]) {
					q.add(new Stone(na,b,nc));
					check[na][nc] = true;
				}
			}
		}
		
		return 0;
	}
	
	static class Stone{
    	int a, b, c;
    	
    	Stone(int a, int b, int c){
    		this.a = a;
    		this.b = b;
    		this.c = c;
    	}
    }
}
