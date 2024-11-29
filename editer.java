package a;

import java.io.*;

public class editer {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int c = sb.length(); //커서 위치
		
		while(n-->0) {
			
			String edit = br.readLine();
			String[] strE=edit.split(" ");
			
			switch(strE[0]) {
			case "L":
				if(c==0)
					break;
				else {
					c--;
					break;
				}
			case "D":
				if(c==sb.length())
					break;
				else {
					c++;
					break;
				}
			case "B":
				if(c==0)
					break;
				else {
					c--;
					sb.deleteCharAt(c);
					break;
				}
			case "P":
				sb.insert(c, strE[1]);
				c++;
			}
			
		}
		System.out.println(sb);
		bw.flush();
		bw.close(); 
	}
	
}
