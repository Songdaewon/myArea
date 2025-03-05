package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrimeNPath_1963 {

	static boolean[] pn = new boolean[10000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		//에라토스테네스의 체 = 소수를 찾는 알고리즘, false값들이 소수임
		for(int i=2;i<10000;i++){
			if(!pn[i]){
				for(int j=i*2;j<10000;j+=i){
					pn[j] = true;
				}
			}
		}
		
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			int result = bfs(cur,goal);
			
			if(result==-1)
				System.out.println("Impossible");
			else
				System.out.println(result);
		}


	}

	private static int bfs(int cur, int goal) {
		Queue<Num> q = new LinkedList<>();
        boolean[] visit = new boolean[10000];
        visit[cur]=true;
        q.add(new Num(cur,0));
        
        while(!q.isEmpty()) {
        	Num p = q.poll();
        	
        	if(p.num==goal)
        		return p.count;
        	
        	//순서대로 일,십,백,천의 자리만을 바꿔 1++씩 변화시켜 확인한다.
        	//가장 먼저 위의 if문에 만족하면 종료
        	int n = p.num/10*10;
        	for(int i=0;i<10;i++) {
        		int temp = n+i;
        		if(!pn[temp]&&!visit[temp]) {
        			visit[temp]=true;
        			q.add(new Num(temp,p.count+1));
        		}
        	}
        	n = (p.num/100*100)+(p.num%10);
        	for(int i=0;i<10;i++) {
        		int temp = n+i*10;
        		if(!pn[temp]&&!visit[temp]) {
        			visit[temp]=true;
        			q.add(new Num(temp,p.count+1));
        		}
        	}
        	n = (p.num/1000*1000)+(p.num%100);
        	for(int i=0;i<10;i++) {
        		int temp = n+i*100;
        		if(!pn[temp]&&!visit[temp]) {
        			visit[temp]=true;
        			q.add(new Num(temp,p.count+1));
        		}
        	}
        	n = p.num%1000;
        	//천의 자리가 0일리가 없기에 1부터 시작
        	for(int i=1;i<10;i++) {
        		int temp = n+i*1000;
        		if(!pn[temp]&&!visit[temp]) {
        			visit[temp]=true;
        			q.add(new Num(temp,p.count+1));
        		}
        	}
        	
        }
        
		return -1;
	}

	static class Num {
		int num, count;

		public Num(int num, int count) {
			this.num=num;
			this.count=count;
		}
	}
}
