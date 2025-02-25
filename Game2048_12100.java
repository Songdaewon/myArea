package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game2048_12100 {

	static int n;
	static int[][] map;
	static int[] swip = new int[5];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bt(0);
		System.out.println(max);
	}
	static void bt(int depth) {

		if(depth==5) {

			int newMap[][] = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					newMap[i][j] = map[i][j];
				}
			}
			for(int i=0; i<5; i++) {
				newMap = swipeAll(swip[i], newMap);
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					max = Math.max(max, newMap[i][j]);
				}
			}

			return;
		}

		//swip에 5번 동안 수행할 명령을 넣는다.
		//처음엔 모두 0,0,0,0,0으로 '상' 명령만 5번 한 것
		//이후 점차 0,0,0,0,1, 0,0,0,0,2 등 으로 명령을 변화한다.  
		for(int i=0;i<4;i++) {
			swip[depth]=i;
			bt(depth+1);
		}
	}
	static int[][] swipeAll(int s, int[][] newMap) {

		switch(s) {
		case 0: //상
			for(int i=0;i<n;i++) {

				int idx=0;
				int block=0;
				for(int j=0;j<n;j++) {

					if(newMap[j][i] != 0){ //0은 빈 칸을 의미
						//만약 두 블록 값이 같다면
						if(block == newMap[j][i]) {
							newMap[idx-1][i] = block*2;
							block = 0;
							newMap[j][i] = 0;
						}
						//다르다면 idx 증가
						//합쳐질 곳의 idx를 갱신하기 위함
						else {
							block = newMap[j][i];
							newMap[j][i] = 0;
							newMap[idx][i] = block;
							idx++;
						}
					}
				}
			}
			break;
		case 1: //하, 상과 반대로
			for(int i=0;i<n;i++) {

				int idx=n-1;
				int block=0;
				for(int j=n-1;j>=0;j--) {

					if(newMap[j][i] != 0){ 
						
						if(block == newMap[j][i]) {
							newMap[idx+1][i] = block*2;
							block = 0;
							newMap[j][i] = 0;
						}
						else {
							block = newMap[j][i];
							newMap[j][i] = 0;
							newMap[idx][i] = block;
							idx--;
						}
					}
				}
			}
			break;
		case 2: //좌
			for(int i=0;i<n;i++) {

				int idx=0;
				int block=0;
				for(int j=0;j<n;j++) {

					if(newMap[i][j] != 0){ 
						
						if(block == newMap[i][j]) {
							newMap[i][idx-1] = block*2;
							block = 0;
							newMap[i][j] = 0;
						}
						else {
							block = newMap[i][j];
							newMap[i][j] = 0;
							newMap[i][idx] = block;
							idx++;
						}
					}
				}
			}
			break;
		case 3: //우
			for(int i=0;i<n;i++) {

				int idx=n-1;
				int block=0;
				for(int j=n-1;j>=0;j--) {

					if(newMap[i][j] != 0){ 
						
						if(block == newMap[i][j]) {
							newMap[i][idx+1] = block*2;
							block = 0;
							newMap[i][j] = 0;
						}
						else {
							block = newMap[i][j];
							newMap[i][j] = 0;
							newMap[i][idx] = block;
							idx--;
						}
					}
				}
			}
			break;
		}
		return newMap;
	}
}





