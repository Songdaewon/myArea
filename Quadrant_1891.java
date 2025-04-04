package DivideandConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quadrant_1891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int d = Integer.parseInt(st.nextToken());
		String s = st.nextToken();

		char[] num = new char[d];
		for(int i=0;i<d;i++) {
			num[i]=s.charAt(i);
		}

		st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long x=0, y=0;	//0,0부터 시작
		long n=d;

		//num의 위치 확인
		for (char i : num) {
            long size=(long)Math.pow(2,--n);

            if(i=='1'){
                x+=size;
            }
            else if(i=='2'){
                //none
            }
            else if(i=='3'){
                y+=size;
            }
            else if(i=='4'){
                x+=size;
                y+=size;
            }
        }
		
		//찾는 값의 위치, 배열 인덱스 기준
		x+=a;	//a는 그대로 더하면 된다
        y-=b;	//b는 양수일 때 위로 가는 건데, 배열 인덱스에선 값이 작아야 위로 가는 것이다.

		String answer="";
		
		for(int i=0;i<d;i++) {
			long limit=(long)Math.pow(2, d-i);		//변의 길이
			long half=(long)Math.pow(2, d-i-1);		//변의 길이의 반

			if(0<=x && x<half && 0<=y && y<half) {	//2사분면
				answer+="2";
			}
			else if(half<=x && x<limit && half>y && y>=0){	//1사분면
				x-=half;
				answer+="1";
			}
			else if(half>x && x>=0 && half<=y && y<limit){	//3사분면
				y-=half;
				answer+="3";
			}
			else if(half<=x && x<limit && half<=y && y<limit){	//4사분면
				x-=half;
				y-=half;
				answer+="4";
			}
		}

		if(answer.length()==d){
			System.out.println(answer);
		}
		else{
			System.out.println(-1);
		}	
	}
}












