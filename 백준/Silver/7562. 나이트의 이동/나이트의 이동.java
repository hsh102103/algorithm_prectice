import java.util.*;

public class Main {
    static class Node {
        public int r;
        public int c;
        public int cnt;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
            this.cnt = 0;
        }

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int L = sc.nextInt();
            map = new int[L][L];
            for (int i = 0; i < L; i++) {
                Arrays.fill(map[i], 0);
            }
            int strR = sc.nextInt();
            int strC = sc.nextInt();
            int endR = sc.nextInt();
            int endC = sc.nextInt();
            if (strR == endR && endC == strC) {
                System.out.println(0);
            } else {
                bfs(strR, strC);
                System.out.println(map[endR][endC]);
            }

        }
    }

    private static void bfs(int strR, int strC) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(strR, strC));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (isNotRange(nr, nc)) continue;
                if (map[nr][nc] != 0) continue;
                map[nr][nc] = cur.cnt + 1;
                q.add(new Node(nr, nc, map[nr][nc]));

            }
        }
    }

    private static boolean isNotRange(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= map.length || nc >= map.length;
    }
}


