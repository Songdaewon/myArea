package a;

import java.io.*;
public class reverse2 {
	//규칙 !!!! < 이 오면 반드시 >가 온다 변수는 없다
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		String str=br.readLine();
		boolean check = false;

		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)=='<') {
				check = true;
				while(sb.length()>0) {
					sb.reverse();
					sb2.append(sb);
					sb.setLength(0);
				}
			}
			else if(str.charAt(i)=='>') {
				check = false;
				sb2.append(str.charAt(i));
				continue;
			}
			
			if(check) {
				sb2.append(str.charAt(i));
			}
			else if(!check) {
				
				if(str.charAt(i)==' ') {   //공백을 만날 시
					while(sb.length()>0) {
						sb.reverse();
						sb2.append(sb+" ");
						sb.setLength(0);
					}
				}
				else {
					sb.append(str.charAt(i));
				}
			}
			
			if(i==str.length()-1) {  //마지막 바퀴 시 싹다 털어 넣기
				while(sb.length()>0) {
					sb.reverse();
					sb2.append(sb);
					sb.setLength(0);
				}
			}
			
		}
		
		System.out.println(sb2);
		br.close();
		
	}

}
