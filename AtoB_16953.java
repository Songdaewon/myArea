package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB_16953 {
	static long a,b;
	static int cnt = 1;
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Long> q = new LinkedList<>();
		q.add(a);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				long t = q.poll();
				if(t==b)
					return cnt;
				
				//q.size*2씩 늘어나지만 이 조건에 해당하지 않는 것들은 가지치기 당함
				//마지막에 남는 놈이 정답, 없으면 -1 반환
				if(t*2<=b)
					q.add(t*2);
				if(t*10+1<=b)
					q.add(t*10+1);
			}
			cnt++;
		}
		return -1;
	}
}





