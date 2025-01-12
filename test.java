package test;
import java.util.*;

public class test {
    
    static int n, m;
    static char[][] board;
    static boolean[][] memo;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int firstX, firstY;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
        scan.nextLine();
        
        board = new char[n][m];
        for(int i = 0; i < n; i++) {
            String str = scan.nextLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
    
        boolean isCircle = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                memo = new boolean[n][m];
                firstX = i;
                firstY = j;
                if(dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        
        System.out.println("No");
    }
    
    public static boolean dfs(int x, int y, int count) {        
        memo[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && board[x][y] == board[nx][ny]) {
                if(memo[nx][ny] == false) {
                    memo[nx][ny] = true;
                    if(dfs(nx, ny, count + 1)) return true;
                } else {
                    if(count >= 4 && firstX == nx && firstY == ny) return true;
                }
            }
        }
        return false;
    }
}
