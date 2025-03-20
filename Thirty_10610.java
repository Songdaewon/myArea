package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thirty_10610 {
	
	static StringBuilder sb = new StringBuilder();
	
	//중요: 이 수가 N의 배수인지 확인하는법
	//각 자릿수를 더하고 N으로 나눌 때 0이 나오면 N의 배수이다. 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		char[] arr = n.toCharArray();
		Arrays.sort(arr); //숫자 오름차순 정렬
		
		int sum=0;
		for(int i=arr.length-1;i>=0;i--) { 
			int num = arr[i]-'0';
			sum+=num;
			sb.append(num);
		}
		
		//30의 배수가 아니라면
		if(arr[0]!='0'||sum%3!=0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sb);
		}
	}

}
