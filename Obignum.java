package a;

import java.io.*;
import java.util.*;
public class Obignum {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		/*
		 * 1.처음 수의 인덱스를 스택에 늠
		 * 2.뒤에 있는 인덱스와 비교
		 * 2-1.현재가 더 클시 뒷수의 인덱스도 삽입 
		 * 2-2.현재가 작을 시 스택에 그 인덱스를 뺴고, 현재 인덱스 자리에 뒷수를 삽입하고, 그 수의 인덱스 삽입
		 * 3.끝날 때까지 stack에 인덱스는 그 자리의 수보다 큰수가 없다는 뜻으로 그 인덱스들에 -1 삽입
		 */
		for(int i=0;i<n;i++) {
			
			while(!stack.empty()&&arr[stack.peek()]<arr[i]) {
				arr[stack.pop()]=arr[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.empty()) {
			arr[stack.pop()]=-1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
		
	}

}
