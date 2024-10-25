import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] marked;
    static int[] arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        marked = new boolean[N + 1];

        recur(0);

        System.out.println(sb);
    }

    static void recur(int size) {
        if (size == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (marked[i]) continue;
            arr[size] = i;
            marked[i] = true;
            recur(size + 1);
            marked[i] = false;
        }
    }
}

