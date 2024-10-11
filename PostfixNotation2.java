package a;

import java.io.*;
import java.util.Stack;
public class PostfixNotation2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			
			if('A'<=ch&&ch<='Z') {
				double d = arr[ch-'A'];
				stack.push(d);
			}
			else {
				 	double d1 = stack.pop();
	                double d2 = stack.pop();
	                double d3 = 0.0;
	                switch(ch) {
	                    case '+' :
	                        d3 = d2 + d1;
	                        break;
	                    case '-' :
	                        d3 = d2 - d1;
	                        break;
	                    case '*' :
	                        d3 = d2 * d1;
	                        break;
	                    case '/' :
	                        d3 = d2 / d1;
	                        break;
	                }
	               stack.push(d3);
			}
		}
		System.out.printf("%.2f",stack.pop());
	}

}
