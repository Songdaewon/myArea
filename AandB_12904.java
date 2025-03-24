package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//중요: S -> T 라고 생각하지 말고 T -> S 라고 생각하는 것
//규칙 변경: T 문자열의 뒤에 A를 제거한다. T 문자열의 뒤에 B를 제거하고 문자열을 뒤집는다.
public class AandB_12904 {
	
	static String s,t;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());
        
        for(int i=t.length()-1;i>=0;i--) {
        	// S와 문자열의 길이가 같아질 때까지 반복
            if (i == s.length()-1) 
                break;
            
            if(t.charAt(i)=='B') {
            	t.deleteCharAt(i);
            	t.reverse();
            }
            else {
            	t.deleteCharAt(i);
            }
        }
        
        if(s.compareTo(t)==0) {
        	System.out.println(1);
        }
        else
        	System.out.println(0);
	}

}
