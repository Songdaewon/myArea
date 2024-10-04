package a;

import java.io.*;
public class Queue{
	
	static int[] Queue;
	static int first=0;   //정수의 개수
	static int last=0;   //정수의 개수
	static int size=0;   //정수의 개수

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Queue = new int[n];
		
		while(n-->0){
			String s = br.readLine();
			String[] str=s.split(" ");
			
			switch(str[0]) {
			
			case "push":
				Queue[last++]=Integer.parseInt(str[1]);
				size++;
				break;
				
			case "pop":
				if(size==0) {
					System.out.println("-1");
				}
				else {
					System.out.println(Queue[first++]);
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
				System.out.println(size==0 ? "-1":Queue[first]);
				break;
			
			case "back":
				System.out.println(size==0 ? "-1":Queue[last-1]);
				break;
			}
		}
	
		br.close();
	}

}
