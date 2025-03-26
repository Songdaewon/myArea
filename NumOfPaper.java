package DivideandConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumOfPaper {
    static int[][] paper; // 종이 내 숫자 구별

    static int minusOne, zero, one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //영상의 크기

        paper = new int[N][N]; //영상 데이터 구성

        for(int i = 0; i < N; i++){ //종이 내부 숫자 입력받기
            st = new StringTokenizer(br.readLine()); //한줄 식 입력받기

            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken()); //띄어쓰기로 쪼개서 입력받기
            }
        }

        br.close();

        cutPaper(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void cutPaper(int row, int col, int size){
    	
    	//1번
    	if(check(row,col,size)) {
    		if(paper[row][col]==-1) {
    			minusOne++;
    		}
    		else if(paper[row][col]==1) {
    			one++;
    		}
    		else if(paper[row][col]==0) {
    			zero++;
    		}
    		return;
    	}
    	
    	//2번
    	int newSize = size/3;
    	
    	for(int i=0;i<size;i+=newSize) {
    		for(int j=0;j<size;j+=newSize) {
    			cutPaper(row+i,col+j,newSize);
    		}
    	}
    	
    	
}

	private static boolean check(int row, int col, int size) {
		
		int init = paper[row][col];
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(paper[i][j]!=init)
					return false;
			}
		}
		
		return true;
	}
}






