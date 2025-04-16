package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//렌선 자르기와 차이점
//랜선: 똑같은 크기로 잘려진 랜선들의 개수들의 합
//나무: 똑같은 크기로 잘려진 나무의 나머지 길이의 합
public class TreeCutting {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int tree[] = new int[n];
        
        int max=0, mid, min=0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	tree[i] = Integer.parseInt(st.nextToken());
        	
        	if(tree[i]>max) {
        		max=tree[i];
        	}
        }
 
        while(min<max) {
        	
        	mid = (max+min)/2;
        	long sum=0;
        	
        	for(int i:tree) {
        		if(i-mid>0) 
        			sum+=i-mid;
        	}
        	
        	
        	if(sum<m) {
        		max=mid;
        	}
        	else {
        		min=mid+1;
        	}
        	
        }
        
        System.out.println(min-1);
	}

}














