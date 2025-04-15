package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이 문제는 각 랜선을 똑같은 크기로 잘라야 한다
public class LANCutting_1654 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        long max=0;
        long mid=0;
        long min=0;
        
        int l[] = new int[K];
        for(int i=0;i<K;i++) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	l[i]=num;
        	if(num>max)
        		max=num;
        }
        
        max++;
        //min과 max를 점차 좁혀가며 답을 구함
        while(min<max) {
        	
        	long n=0;
        	mid=(max+min)/2;
        	
        	
        	for(int i:l)
        		n+=i/mid;
        	
        	//케이블이 모자랄 때-길이를 더 줄이기 위해 max를 줄임
        	if(n<N) {
        		max=mid;
        	}
        	//정답 혹은 케이블이 너무 많을 때-길이를 늘이기 위해 min을 늘림
        	//+1로 하지 않으면 무한루프 발생 min이 max를 추월 못함
        	else {
        		min=mid+1;
        	}
        	
        	
        }
        //위에서 +1을 했기에 -1
        System.out.println(min-1);
	}

}
