package a;

import java.io.*;
import java.util.*;

public class ObackBignum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack =new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] count = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
		}

		
		for(int i=0;i<n;i++) {
			
			while(!stack.empty() && count[arr[i]] > count[arr[stack.peek()]]) {
				arr[stack.pop()] = arr[i]; 
			}
			
			stack.push(i);
		}
		
		while(!stack.empty()) {
			arr[stack.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) 
			sb.append(arr[i]+" ");
		
		System.out.println(sb);
	}

}
