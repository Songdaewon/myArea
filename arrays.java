import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int answer[] = new int[commands.length];

        for (int cx = 0; cx < commands.length; cx++) {
            int i = commands[cx][0];
            int j = commands[cx][1];
            int k = commands[cx][2];

            //범위값만 복사
            int[] array2 = Arrays.copyOfRange(array, i - 1, j);

            Arrays.sort(array2);
            answer[cx] = array2[k - 1];
        }
        return answer;
    }
}

public class arrays{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int array[] = new int[100];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int idx = 0;
        while (st.hasMoreTokens()) {
            array[idx++] = Integer.parseInt(st.nextToken());
        }

        //커맨드 입력: 빈 줄을 입력하면 종료
        int[][] commands = new int[50][3];
        int count = 0; // 실제로 입력된 명령어 개수
        int x=0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            if(st.countTokens()!=3) break;
            for (int i = 0; i < 3; i++) {
                commands[x][i] = Integer.parseInt(st.nextToken());
            }
            ++x;
            ++count;
        }
        int[][] finalCommands = Arrays.copyOf(commands, count);

        Solution solution = new Solution();
        int[] ans = solution.solution(array,finalCommands);
        for(int i:ans) {
            System.out.print(i+" ");
        }
    }



}


