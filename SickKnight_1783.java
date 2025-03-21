package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중요: 도달할 수 있는 영역의 개수가 4개 이상이 되려면, 4종류의 모든 움직임을 다 사용하여야 한다
//즉 4종류의 움직임을 모두 사용할 수 없다면 최대 움직일 수 있는 땅은 4개이다
public class SickKnight_1783 {

	public static void main(String[] args)	throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//n이 1일시 도달할 수 있는 장소가 제자리 말고 없음
		if(n==1) {
			System.out.println(1);
		}
		
		//n이 2일시 (2,3)번 움직임을 반복적으로 수행 = 오른쪽으로 2칸씩 이동 = [(m+1)/2<=이동값<=4]
		else if(n==2) {
			System.out.println(Math.min(4, (m+1)/2)); 
		}
		
		else if(n>=3) {
			//n 3이상,m 6이하 = (1,4)번 동작 반복 실행 = 오른쪽으로 1칸씩 이동 = [m<=이동값<=4]
			if(m<=6) {
				System.out.println(Math.min(4, m));   
			}
			//n 3이상,m 7이상 = 모든 움직임을 사용해야함 = (2,3)번 두 칸씩 이동하기에 1번씩만 사용해야함, 이때 빈공간 2칸이 발생(이걸 대체 어떻게 암????)
			//m-2(2,3번의 몫)
			else {
				System.out.println(m-2);
			}
		}
	}
}
