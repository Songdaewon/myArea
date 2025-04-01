package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rollercoster_2873 {

	static int r,c;
	static int map[][];
	static int visit[][];

	//모든 칸을 지나는 것이 가장 큰 기쁨이지만 r과 c가 둘 다 짝수 일때는 모든 칸을 지나갈 수 없다.
	//무조건 하나를 스킵해야함. 스킵은 당연히 기쁨이 가장 작은 칸이어야 한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String answer = "";
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//둘 중 하나가 홀일시 모든 곳을 이동할 수 있다.
		//백준에서 정답은 여러 개라고 했지만 하나로 고정시키지 말라고도 안했다.
		if(r%2!=0 || c%2!=0) {

			//r이 홀일 시, ㄹ자 형태로 이동
			if(r%2!=0) {
				for(int i=1;i<=r;i++){
					for(int j=1;j<c;j++) {		
						if(i%2 != 0)	//1. 맨 처음 오른쪽 이동
							answer += "R";
						else			//3. 그 다음 왼쪽 이동
							answer += "L";
					}	
					if(i!=r)			//2. 한 행 끝나면 아래로 이동
						answer += "D";
				}
			}
			//r은 짝일 시
			else {
				for(int i=1;i<=c;i++){
					for(int j=1;j<r;j++) {		
						if(i%2 != 0)	//1. 맨 처음 아래로 이동
							answer += "D";
						else			//3. 그 다음 위로 이동
							answer += "U";
					}	
					if(i!=c)			//2. 한 행 끝나면 오른쪽 이동
						answer += "R";
				}
			}
			System.out.println(answer);

		}
		//짝짝
		else {
			int x=0;
			int y=1;

			//스킵할 구간 정하기
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if((i+j)%2!=0) {
						if(map[x][y]>map[i][j]) {
							x=i;
							y=j;
						}
					}
				}
			}
			int x1 = 0;
			int y1 = 0;

			int x2 = r-1;
			int y2 = c-1;

			StringBuilder s1 = new StringBuilder();
			StringBuilder s2 = new StringBuilder();

			//시작점과 도착점에서 서로 출발하여 만나게 하는 방식
			//스킵할 칸의 행이 [홀수]이면 시작점의 행과 스킵점의 행이 같을 때 시작점은 멈춰야함.
			//스킵칸의 행과 도착점의 행의 차이가 1일때 도착점은 멈춰야함.
			
			//스킵칸의 행이 [짝수]이면 반대다. 시작점행과 스킵행의 차이가 1일시 시작은 멈추고,
			//도착과 스킵의 행이 같으면 도착은 멈춘다.
			
			//x1/2 < x/2 , x2/2 > x/2
			//y1/2 < y/2 , y2/2 > y/2
			while(x2-x1>1) {
				if(x1/2 < x/2) {
					append(s1, 'R', c-1);
					append(s1, 'D', 1);
					append(s1, 'L', c-1);
					append(s1, 'D', 1);
					x1+=2;  //D를 한 만큼
				}
				if(x/2 < x2/2) {
					append(s2, 'R', c-1);
					append(s2, 'D', 1);
					append(s2, 'L', c-1);
					append(s2, 'D', 1);
					x2-=2;	//D를 한 만큼
				}
			}

			while(y2-y1 > 1) {
				if(y1/2 < y/2) {
					append(s1, 'D', 1);
					append(s1, 'R', 1);
					append(s1, 'U', 1);
					append(s1, 'R', 1);
					y1+=2;	//R를 한 만큼
				}
				if(y/2 < y2/2) {
					append(s2, 'D', 1);
					append(s2, 'R', 1);
					append(s2, 'U', 1);
					append(s2, 'R', 1);
					y2-=2;	//R를 한 만큼
				}
			}
			//스킵된 부분과 시작점의 열이 같다면
			if(y==y1) {
				s1.append("R");
				s1.append("D");
			}
			else {
				s1.append("D");
				s1.append("R");
			}
			s2.reverse();
			s1.append(s2);
			System.out.println(s1);
		}
	}

	public static void append(StringBuilder s,char c, int cnt) {
		for(int i=0; i<cnt; i++) 
			s.append(c);
	}
}












