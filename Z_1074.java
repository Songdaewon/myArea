package DivideandConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {

	static int N,r,c, size=1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		size = (int)Math.pow(2, N);

		int cnt=0;
		int x=0;
		int y=0;
		
		//이분탐색으로 사이즈를 점점 작게 탐색해 나감
		//중요:m분면의 시작점은 m-1의 시작점 보다 [(2^n/2)*(2^n/2)]만큼 크다
		while(size>0) {
			
			size/=2;
			
			//왼쪽 위
			if(r<x+size && c<y+size) {
				cnt+=0;
			}
			//오른쪽 위
			else if(r<x+size) {
				cnt += size*size;
				y+=size;
			}
			//왼쪽 아래
			else if(c<y+size) {
				cnt += size*size*2;
				x+=size;
			}
			//오른쪽 아래
			else {
				cnt += size*size*3;
				x+=size;
				y+=size;
			}
			
			if(size==1) {
				System.out.println(cnt);
				break;
			}
		}
	}
}














