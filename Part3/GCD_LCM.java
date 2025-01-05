package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_LCM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(b>a) {
			int temp = a;
			a=b;
			b=temp;
		}
		
		int gcd = getGCD(a, b);
        System.out.println(gcd);
        System.out.println((a * b) / gcd);
		
	}
	
	public static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}

//최대공약수
/*두 개 이상의 수가 공통으로 갖는 가장 큰 공약수*/
//최소공배수
/*두 개 이상의 수가 공통으로 갖는 가장 작은 공배수*/



