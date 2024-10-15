import java.io.*;

public class Main {
    static int[][] map;
    static int N;
    static int targetNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        targetNum = Integer.parseInt(br.readLine());

        int r  = N / 2;
        int c  = N / 2;
        tr = r+1;
        tc = c+1;

        map = new int[N][N];
        map[r][c] = 1;
        search(r, c);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(tr).append(" ").append(tc);
        System.out.println(sb);
    }

    static int tr;
    static int tc;

    static void search(int r, int c) {
        int insertNum = 2;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int cnt = 0;
        int d = 0;
        while (cnt++ < 2) { // 새 방향이 벽이고, 원래방향도 벽이면 끝
            int nr = dr[d % 4] + r;
            int nc = dc[d % 4] + c;

            if (isNotRange(nr, nc) || map[nr][nc] != 0) d--;
            else {
                isTarget(insertNum, nr, nc);
                map[nr][nc] = insertNum++;
                cnt = 0;
                r = nr;
                c = nc;
                d++;
            }
        }
    }

    static void isTarget(int num, int r, int c) {
        if (num == targetNum) {
            tr = r + 1;
            tc = c + 1;
        }
    }

    static boolean isNotRange(int r, int c) {
        return r >= N || c >= N || r < 0 || c < 0;
    }
}


