package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//A와 B의 쌍 = A의 개수*B의 개수
//이때 'A의개수*B의 개수 = K'면 해당 개수 만큼 문자열을 만들 수 있음
//i는 j보다 무조건 작기에 A가 왼쪽에 있을 때 쌍의 개수가 최대(A*B)가 된다.

//ex) N=12, K=27
//A=3, B=9가 있어야함 [A*B=K]
//먼저 배열을 B로 다 채우고 'A의 개수 - 1' 만큼 왼쪽부터 A로 채워준다.
//AABBBBBBBBBB
// 마지막 부분을 A로 만들어준다.
//AABBBBBBBBBA

/*
AABBBBBBBBBA 쌍: 18 
AABBBBBBBBAB 쌍: 19 
AABBBBBBBABB 쌍: 20
AABABBBBBBBB 쌍: 27
*/

public class AB_12970 {
	
	static int n,k;
	static int aL = 0; //A만 구하면 B도 구해짐
	static String s="";
	static String result[];
	

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    
	    aL = checkLength();
	    if(aL==-1) {
	    	System.out.println(-1);
	    	return;
	    }
	    int bL = n-aL;
	    
	    result = new String[n];
	    if(aL!=-1 && k!=0) { //일반적인 경우
	    	
	    	//B를 먼저 채우고
	    	for(int i=0;i<n;i++) {
	    		result[i]="B";
	    	}
	    	//A-1만큼 왼쪽을 채운다
	    	for(int i=0;i<aL-1;i++) {
	    		result[i]="A";
	    	}
	    	
	    	
	    	int c = (aL-1)*bL;	//(A-1)*B
	    	int r = k-c;		//k에서 위의 값을 뺀 다음
	    	result[(n-1)-r]="A";	//맨 뒤 인덱스에서 r을 빼서 남은 A의 자리를 찾음
	    }
	    else if(k==0) {
	    	//K가 0이라면 AB쌍이 의미가 없음
	    	for(int i=0;i<n;i++) {
	    		result[i]="B";
	    	}
	    }
	    for(String i:result) {
	    	System.out.print(i);
	    }
	}


	private static int checkLength() {
		int aL = 1;
		int bL = n-1;
		
		while(aL*bL<k) {
			if(bL<0)
				return -1;
			
			aL++;
			bL--;
		}
		
		return aL;
	}
}














