package DivideandConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumCard {
	
	static int n,m;
	static int num[];

	//for문 2개를 사용해 해결할 수 있으나 그러면 O(n^2)이 걸린다. (n과m의 범위는 같음)
	//하지만 2진 탐색은 평균 O(logn)이 결려 더 빠르다. (이 둘의 차는 하늘과 땅 차이)
	public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        num=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	num[i]=Integer.parseInt(st.nextToken());
        }
        
        //중요: 오름차 정렬
        Arrays.sort(num);
        
        m = Integer.parseInt(br.readLine());
        
        
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
        	boolean isFind = false;
        	int find=Integer.parseInt(st.nextToken());
        	
        	int left = 0;
        	int right = n-1;
        	
        	//이분탐색
        	while(left<=right) { 	
        		int mid = (left+right)/2;
        		int midV = num[mid];
        		
        		if(find>midV) { 	//찾는 값이 오른족에 있으니 왼쪽을 떙겨옴
        			left = mid+1;
        		}
        		else if(find<midV) {//찾는 값이 왼쪽에 있으니 오른쪽을 떙겨옴
        			right = mid-1;
        		}
        		else {              //찾았으니 정지
        			isFind=true;
        			break;
        		}
        	}
        	
        	if(isFind) {
        		sb.append(1+" ");
        	}
        	else {
        		sb.append(0+" ");
        	}
        }
        
       
       
        
        System.out.println(sb);
	}

}















