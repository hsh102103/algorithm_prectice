import java.util.*;

/***
 * RGB색이 연속되지않게 N개의 집을 칠할때 비용의 최소값 구하는 문제
 *
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][3];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < 3; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        int[][] dp = new int[N][3];
        for (int c = 0; c < 3; c++) {
            dp[0][c] = map[0][c];
        }
        for (int i = 1; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int r = 0; r < N-1; r++) {
            for (int c = 0; c < 3; c++) {
                for (int dc = 0; dc < 3; dc++) {
                    if(c==dc) continue;
                    dp[r+1][c] = Math.min(dp[r][dc] + map[r+1][c], dp[r+1][c]);

                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(dp[N-1][i], ans);
        }
        System.out.println(ans);
    }
}


