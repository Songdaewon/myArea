package DivideandConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerOfHanoi_11729 {
	
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		sb.append((int)(Math.pow(2, n)-1)+"\n"); //법칙: 2^n-1 = 움직인 횟수
		hanoi(n,1,2,3);
		
		System.out.println(sb);
	}

	private static void hanoi(int n, int start, int tmp, int goal) {
		
		if(n==1) { //하나만 남았다면 그냥 3번째로 보내면 됨
			sb.append(start+" "+goal+"\n");
			return;
		}
		
		//탑 크기가 짝수면 맨 위의 것을 2번째 위치에 
		//홀수면 3번째에 둔다.
		hanoi(n-1,start, goal, tmp);
		
		sb.append(start+" "+goal+"\n");
		
		hanoi(n-1,tmp,start,goal);
		
		
	}
}












