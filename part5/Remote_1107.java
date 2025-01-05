package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//너무 어렵다
public class Remote_1107 {
	static int re;
	static boolean broken[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		//순전히(+/-)를 눌러 채널을 이동하는 수
		re = Math.abs(n-100);
		
		//고장난 버튼이 없을시
		if(m==0) {
			//+/-로 이동하는 경우의 수 vs 숫자를 눌러 채널을 이동하는 경우의 수
			re = Math.min(re,String.valueOf(n).length());
			System.out.println(re);
		}
		//고장난 버튼이 있을 시
		else {
			StringTokenizer st = new StringTokenizer(br.readLine());
			broken=new boolean[10];
			for(int i=0;i<m;i++) {
				broken[Integer.parseInt(st.nextToken())]=true;
			}
			//n=50만 일때 52만 혹은 48만에서 시작할 수 있으니 100만번 검사
			for(int i=0;i<1000000;i++) {
				
				String str = String.valueOf(i);
				//만약 해당 버튼이 잘 작동한다면
				if(check(str)) {
					//해당 숫자 버튼을 누르는 횟수+(+/-를 누르는 횟수)로 최솟값 계속 갱신
					re=Math.min(re, str.length()+Math.abs(n-i));
				}
			}
			System.out.println(re);
		}
	}
	static boolean check(String str) {
		/*5457
		 *3
		 *6 7 8의 경우
		 *5455=사용 가능한 버튼
		 *5456이 들어왔다 = 하지만 마지막 6번에서 걸리기 때문에 이 번호는 사용 불가하다
		 */
        for (int j = 0; j < str.length(); j++) {
            if (broken[str.charAt(j) - '0']) {
                return false;
            }
        }
 
        return true;
    }
}
