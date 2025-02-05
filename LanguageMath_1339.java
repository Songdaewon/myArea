package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LanguageMath_1339 {
	static int n;
	static int arr[] = new int[26];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        while(n-->0) {
        	String str = br.readLine();
        	for(int i=0;i<str.length();i++) {
        		char c = str.charAt(i);
        		arr[c-'A'] += (int)Math.pow(10, str.length()-1-i);
        	}
        }
        //오름차순
        Arrays.sort(arr);
        
        int num=9;
        int turn=25;
        int ans=0;
        //숫자가 큰 것부터 9를 곱하고 숫자가 없어질 때까지
        //9--를 곱함
        while(arr[turn]!=0) {
        	ans+=arr[turn]*num;
        	turn--;
        	num--;
        }
        
        System.out.println(ans);
	}

}
