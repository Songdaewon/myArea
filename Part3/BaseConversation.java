package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaseConversation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());
		
		int sum=0;
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {

			int s=Integer.parseInt(st.nextToken());;
			sum+= s * (int)Math.pow(a,--n);

		}
		while(sum>0) {
			
			stack.push(sum%b);
			sum/=b;
			
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
