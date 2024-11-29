package a;

import java.util.*;

public class Main {
	public static int stack[]; 
	public static int size = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int n = scan.nextInt();
		stack = new int[n];
		
		for(int i = 0; i<n; i++) {
			String str = scan.next();		
			
			switch(str) {
			case "push":
				push(scan.nextInt());
				break;
				
			case "pop":
				pop();
				break;
				
			case "size":
				size();
				break;
				
			case "empty":
				empty();
				break;
			
			case "top":
				top();
				break;
			}		
		}
		scan.close();
}
	
	static void push(int item) {
		if(size < stack.length) {
			stack[size] = item;
			size++;
		} else {
			System.out.println("Stack is full");// 스택이 가득 찼을 경우
        }
		
	}
	
	static void pop() {
		if(size==0) {
			System.out.println("-1");
			return;
		}
		
		int em = stack[size-1];
		size--;
		System.out.println(em);
	}
	
	static void size() {
		System.out.println(size);
	}
	
	static void empty() {
		System.out.println(size == 0 ? "1" : "0");
	}
	
	static void top() {
		if(size==0) {
			System.out.println("-1");
		}
		else {
			System.out.println(stack[size-1]);
		}
	}
}

/*





*/