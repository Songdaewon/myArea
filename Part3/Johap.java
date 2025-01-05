package Part3;
/*
 * 팩토리얼의 뒤에 0이 오는 경우는 2와 5가 곱해졌을 경우이다.
 * 2가 팩토리얼에 있는 경우보다 5가 있는 경우가 더 적으니 5의 개수를 세는 것이 옳다
 * 하지만 5의 수 마다 0이 증가하지 않고, 카운트가 20일떄(5=4개)일때 0이 4였다가 25가 되니 0이 6이된다.
 * 즉 5로 나누는 것만이 아닌 5보다 작아질 때까지 누적합으로 계산해야 한다.
 */
/*
 * 팩토리얼은 5의 승수만 구하면 됬지만
 * 조합은 n!, (n-m)!, m! 의 2와 5의 승수를 구하고 이들을 각각 빼준다.
 * 그리고 2와 5의 승수 중 작은 것을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Johap {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n=Integer.parseInt(st.nextToken());
		long m=Integer.parseInt(st.nextToken());
		
		long c5 = C5(n)-C5(n-m)-C5(m);
		long c2 = C2(n)-C2(n-m)-C2(m);
		
		System.out.println(Math.min(c5, c2));
	}
	
	static int C5(long i) {
		int count = 0;

		while(i>=5) {
			count+=i/5;
			i/=5;
		}
		return count;
	}
	
	static int C2(long i) {
		int count = 0;
		
		while(i>=2) {
			count+=i/2;
			i/=2;
		}
		return count;
	}
}
