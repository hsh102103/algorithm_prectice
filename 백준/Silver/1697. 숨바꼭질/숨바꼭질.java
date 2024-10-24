import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        map[N] = 0;
        bfs(N, K);
        System.out.println(map[K]);
    }

    static int[] map = new int[100001];

    static {
        Arrays.fill(map, Integer.MAX_VALUE);
    }

    private static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now - 1 >= 0 && map[now - 1] == Integer.MAX_VALUE) {
                q.add(now - 1);
                map[now - 1] = map[now] + 1;
            }
            if (now + 1 < map.length && map[now + 1] == Integer.MAX_VALUE) {
                q.add(now + 1);
                map[now + 1] = map[now] + 1;
            }
            if (now * 2 < map.length && map[now * 2] == Integer.MAX_VALUE) {
                q.add(now * 2);
                map[now * 2] = map[now] + 1;
            }
            if (map[target] != Integer.MAX_VALUE) break;
        }

    }
}


