import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] ansArr = new int[N]; // 각 사람의 2-친구를 넣을 배열
        map = new int[N][N]; // 입력받을 2차원 배열
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                char friend = s.charAt(j);
                if (friend == 'N') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                    check(i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == true) {
                    ansArr[i]++;
                }
            }
        }
        for (int i = 0; i < ansArr.length; i++) {
            ans = Math.max(ans, ansArr[i]);
        }
        System.out.println(ans);
    }

    static int check(int pre, int cur) {
        int isFriend = 0;
        for (int i = 0; i < N; i++) {
            if(pre == i) continue;
            if (map[cur][i] == 1) {
                isFriend++;
                visited[pre][i] = true;
            }
        }

        return isFriend;
    }
}