import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku_2580 {
	static int sudoku[][]=new int[9][9];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<9;j++) {
        		sudoku[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        check(0,0);
	}
	static void check(int row,int col) {
		//다음 행
		if(col == 9){
            check(row+1, 0);
            return;
        }
		//모든 행을 다 확인했을 경우 출력 및 종료
		if(row==9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(sudoku[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		

        //빈칸일 시
        if(sudoku[row][col] == 0){
            for(int i = 1; i <= 9; i++){
                if(checkSameNum(row, col, i)){ //넣을 수 있는 숫자이면
                    sudoku[row][col] = i; //숫자를 넣고
                    check(row, col+1); //다음 열의 수를 확인
                }
            }
            sudoku[row][col] = 0; //다른 경우의 수를 확인하기 위해 다시 0으로 돌려놓는다.
            return;
        }

        //숫자가 존재할 경우 다음 열 검사
        check(row, col+1);
	}

	// 같은 열/행에 해당 숫자가 있는지 없는 지 체크하여 있으면 false, 없으면 true
	public static boolean checkSameNum(int row, int col, int num){
        /* 열에 해당 숫자가 있는지 체크 */
        for(int i = 0; i < 9; i++){
            if(sudoku[row][i] == num){ //열을 증가시키면서 열에 존재하는지 확인
                return false;
            }
        }

        /* 행에 해당 숫자가 있는지 체크 */
        for(int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }
        
        //7/3*3=6, 8/3*3=6
        int rowLocation = (row/3)*3; //행의 첫 위치
        int colLocation = (col/3)*3; //열의 첫 위치

        /* 존재하는 값의 위치에 해당하는 3x3 행렬에 있는지 체크 */
        for(int i = rowLocation; i < rowLocation+3; i++){
            for(int j = colLocation; j < colLocation+3; j++){
                if(sudoku[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
