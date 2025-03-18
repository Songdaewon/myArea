package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//일단 최솟값을 찾으려면 어떻게 해야하는가
//+식들끼리 괄호를 닫아 큰 값으로 만들고 그 값 앞에 -를 붙이면 된다. 

//즉 -를 기준으로 식(문자열)을 나눈다. 맨 처음 나눠진 +식 혹은 숫자를 형변환해 초기값으로 지정
//이후 -로 나눴으니 각각의 덩어리들을 초기값에서 빼주기만 하면 간단하게 해결 가능하다.
public class LostBacket_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String exp = br.readLine();
		String arr[]=exp.split("\\-");

		int ans = cal(arr[0]);
		
		for(int i=1;i<arr.length;i++) {
			ans -= cal(arr[i]);
		}
		
		System.out.println(ans);
	}

	private static int cal(String exp) {
		String temp[] = exp.split("\\+");
		int result=0;
		
		for(int i=0;i<temp.length;i++) {
			result+=Integer.parseInt(temp[i]);
		}
		
		return result;
	}

}
