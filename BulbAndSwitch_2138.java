package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//그리디로 해결하려면 단순히 현재 맞지 않은 전구를 똑같이 맞추면 된다. 하지만
//한 번 지나간 전구는 다시는 돌아가 누르면 안됨 == i+1에서 시작
//그리고 처음에 0번째를 누른 것과 아닌 경우에서 결과가 달라짐
public class BulbAndSwitch_2138 {
	static int n;
	static int bulb1[];
	static int bulb1PressOne[];
	static int bulb2[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		bulb1 = new int[n]; 
		bulb2 = new int[n]; 

		String str = br.readLine();
		for(int i=0;i<n;i++) {
			bulb1[i] = str.charAt(i)-'0';
		}

		bulb1PressOne = Arrays.copyOf(bulb1, n);

		bulb1PressOne[0]=bulb1[0]== 1 ? 0:1;
		bulb1PressOne[1]=bulb1[1]== 1 ? 0:1;

		str = br.readLine();
		for(int i=0;i<n;i++) {
			bulb2[i] = str.charAt(i)-'0';
		}

		//전구의 첫 번째 버튼을 누른지 않은 경우와 누른 경우를 나눔
		int count = 0;	
		int pressOneCount = 1;

		for(int i=1;i<n;i++) {
			if(bulb1[i-1]!=bulb2[i-1]) {
				bulb1[i-1] = bulb1[i-1] == 1?0:1;
				bulb1[i] = bulb1[i] == 1 ? 0 : 1;

				if(i+1 < n){
					bulb1[i+1] = bulb1[i+1] == 1 ? 0 : 1;
				}
				count++;
			}

			if(bulb1PressOne[i-1]!=bulb2[i-1]) {
				bulb1PressOne[i-1] = bulb1PressOne[i-1] == 1?0:1;
				bulb1PressOne[i] = bulb1PressOne[i] == 1 ? 0 : 1;

				if(i+1 < n){
					bulb1PressOne[i+1] = bulb1PressOne[i+1] == 1 ? 0 : 1;
				}
				pressOneCount++;
			}
		}

		if(isSame(bulb1,bulb2)){
			System.out.println(count);
		}else if(isSame(bulb1PressOne,bulb2)){
			System.out.println(pressOneCount);
		}else{
			System.out.print(-1);
		}
	}

	public static boolean isSame(int[]a, int[]b){
		for(int i=0;i<a.length;i++){
			if(b[i] != a[i]){
				return false;
			}
		}

		return true;
	}
}













