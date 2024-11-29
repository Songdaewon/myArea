package a;

import java.util.*;
public class VPS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		int n = scan.nextInt();
		
		for(int j=0;j<n;j++) {
			String str = scan.next();
			
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				if(ch=='(') {
					stack.push(ch);
				}
				else {
					if(stack.size()==0) {
						stack.push(ch);
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
			stack.clear();
		}
		
	}
}
