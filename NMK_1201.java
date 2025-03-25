package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//전체 배열에서 k만큼의 수로 하나의 묶음을 만든다.
//(나머지 배열 크기/m-1)만큼 묶음을 만들고, 나머지는 아무 묶음에다 넣는다.
//그리고 각 묶음을 뒤집는다. 그러면 정답이 나온다.

//m개 만큼의 묶음은 꼭 만들어야 하고, 최소 한 묶음에 최대 k개의 수가 있으면 된다.
public class NMK_1201 {

	static int n,m,k;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    
	    int end[] = new int[m+1]; //각 묶음들의 마지막 수 저장 == 각 묶음을 나눔
	    int first = n-k; 
	    
	    //1.m=1, k=n || m=n, k=1 식이 성립, m+k는 최소 n+1이어야 한다.
	    //m+k>n+1이 성립되면 사용해야 할 수가 부족해 진다.
	    
	    //2. 수열 최대 길이는 m*k이다. 그렇기에 n이 m*k보다 크면 모든 수를 사용할 수 없다.
	    if(m+k>n+1||m*k<n) {
	    	System.out.println(-1);
	    	return;
	    }
	    
	    end[1]=k; //첫 묶음의 마지막 수
	    
	    if(m>1) {
	    	int bun = (n-k)/(m-1);//새로 만들어야 될 묶음에 들어가야 할 수의 개수
	    	int rest= (n-k)%(m-1);//나머지
	    	
	    	for(int i=2;i<=m;i++) {
	    		if(rest-->0) {
	    			end[i]=end[i-1]+bun+1;
	    		}
	    		else {
	    			end[i]=end[i-1]+bun;
	    		}
	    	}

	    }
	    
	    for(int i=1;i<=m;i++) {
	    	for(int j=end[i];j>=end[i-1]+1;j--) {
	    		System.out.print(j+" ");
	    	}
	    }
	    
	    //각 묶음을 뒤집어서 출력

	    
	}

}







