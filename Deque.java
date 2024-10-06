package a;

import java.io.*;
public class Deque {

	static int[] deque = new int[20001];;
	static int first=10000;   //정수의 개수
	static int last=10000;   //정수의 개수
	static int size=0;   //정수의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-->0) {
			
			String s = br.readLine();
			String[] str=s.split(" ");
			
			switch(str[0]) {
			
				case "push_front":
					deque[first--]=Integer.parseInt(str[1]);
					size++;
					break;
					
				case "push_back":
					deque[++last]=Integer.parseInt(str[1]);
					size++;
					break;
					
				case "pop_front":
					if(size==0) {
						System.out.println("-1");
					}
					else {
						System.out.println(deque[++first]);
						size--;
					}
					break;
					
				case "pop_back":
					if(size==0) {
						System.out.println("-1");
					}
					else {
						System.out.println(deque[last--]);
						size--;
					}
					break;
					
				case "size":
					System.out.println(size);
					break;
					
				case "empty":
					System.out.println(size==0 ? "1":"0");
					break;
					
				case "front":
					System.out.println(size==0 ? "-1":deque[first+1]);
					break;
					
				case "back":
					System.out.println(size==0 ? "-1":deque[last]);
					break;
			}
		}
		br.close();
	}

}
