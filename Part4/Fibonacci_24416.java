package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_24416 {
	static int[] f; 
	static int code1Cnt,  code2Cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine()); //입력 값(n)
		f = new int[n];
		code1Cnt = 0;
		code2Cnt = 0;

		fib(n);
		fibonacci(n);

		System.out.println(code1Cnt + " " + code2Cnt);
	}


	static int fib(int n) {
		if(n == 1 || n == 2){
            code1Cnt++; //1이 몇번 더해졌는지 구하면 되기 떄문에 if문 안에
            return 1;
        }
        else return (fib(n-1) + fib(n-2));
	}
	static int fibonacci(int n) {
		f[0] = 1;
		f[1] = 1;
		for(int i = 2; i < n; i++){
			//for문의 반복 횟수가 속도를 결정
			code2Cnt++;
			f[i] = f[i-1] + f[i-2];
		}
		return f[n-1]; //배열은 0부터 시작하므로
	}
}
