package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumFinding_1920 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
        	if(BS(arr,Integer.parseInt(st.nextToken()))>=0) {
        		sb.append(1+"\n");
        	}
        	else {
        		sb.append(0+"\n");
        	}
        }
        System.out.println(sb);

	}

	private static int BS(int[] arr, int key) {
		
		int min=0, max=arr.length-1;
		
		while(min<=max) {
			
			int mid = (min+max)/2;
			
			//-1과 +1를 하는 경우
			//Up & Down 게임에서 1~100의 범위에서 50을 외쳤는데 Down이라면,
			//그 다음에는 50을 제외한 1~49 사이의 수가 탐색 범위
			if(key<arr[mid]) {
				max=mid-1;
			}
			else if(key>arr[mid]) {
				min=mid+1;
			}
			else {
				return mid;
			}
			
		}

		return -1;
	}

}






