package a;

import java.io.*;
import java.util.*;
public class PostfixNotation {
	
	public static void main(String[] args) throws IOException{
		Stack<Character> stack = new Stack<>();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		String input = br.readLine();
		
		for(int i=0;i<input.length();i++) {
			char temp = input.charAt(i);
			
			if(temp=='+'||temp=='-'||temp=='*'||temp=='/') { //연산자
				
				while(!stack.empty()&&Num(stack.peek())>=Num(temp)) {
					sb.append(stack.pop());
				}
				stack.push(temp);
				
			}
			else if(temp=='(') {
				stack.push('(');
			}
			else if(temp==')') {
				while(!stack.empty()) {
					if(stack.peek()=='(') {
						stack.pop();
						break;
					}
					sb.append(stack.pop());
				}
			}
			else {  //일반 피연산자
				sb.append(temp);
			}
		}
		
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);

		br.close();
	}
	
	//( 를 이 함수에 포함시키는 이유 : 스택에 (를 남기기 위해서
	//이 함수에서 우선순위는 0으로 그 어떤 연산자가 와도 (는 스택에 남는다
	//비교 당하는 값에 (는 올 일이 없다 Num함수는 연산자만 받게 if문으로 설계되었으니까
	static int Num(char temp) {
		if(temp == '(') return 0;
		else if(temp == '+' || temp == '-') return 1;
		else return 2;
	}
}
/*
1. 식을 입력 받음
2. 검사를 진행한다 
3. 연산자가 아니라면 바로 sb에 넣는다
4. 모든 연산자는 스택에 넣는다.
4-1. 여는 괄호 이후 닫는 괄호가 등장한다면 그 사이에 있는 존재한 모든 연산자를 sb에 넣는다. 
5. 만약 마지막에 저장된 연산자의 우선순위가 이후에 나온 연산자 보다 크거나 같다면 모두 pop해서 sb에 저장
6. 검사가 끝나고 스택에 남은 연산자는 전부 처리한다.
*/
