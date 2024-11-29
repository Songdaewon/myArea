package a;
import java.io.*;
import java.util.Stack;

public class numerical {
	
	static int sN=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num>sN) {
				for(int i=sN+1;i<=num;i++) {
					stack.push(i);
					sb.append("+\n");
				}
				sN=num;
			}
			
			if(stack.peek()!=num) {
				System.out.println("NO");
				return;
			}
			else {
				stack.pop();
				sb.append("-\n");
			}
		}
		System.out.println(sb);
	}

}
