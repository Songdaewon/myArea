package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//(중요)
//종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다 == 종료시간을 기준으로 정렬
public class MeetingRoom_1931 {
	
	static int n;
	static int[][] time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		
		time = new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time,new Comparator<int[]>() {
			//종료시간을 기준으로 정렬하지만 같다면 시작시간이 빠른 것을 더 앞에 두는 오버라이드 함수
			@Override
			public int compare(int[] o1,int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				
				return o1[1]-o2[1];
			}
		
		});
		
		int count=0;
		int prev=0;
		
		for(int i=0;i<n;i++) {
			if(prev<=time[i][0]) {
				prev=time[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}













