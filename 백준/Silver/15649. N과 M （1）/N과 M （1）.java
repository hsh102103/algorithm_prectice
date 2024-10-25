import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static boolean[] marked;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자 갯수
        int R = Integer.parseInt(st.nextToken()); // 한줄에 보여줄 갯수
        int[] arr = new int[R];
        sb = new StringBuilder();
        marked = new boolean[N + 1];

        permutation(0, N, R, arr);
        System.out.println(sb.toString());
    }

    private static void permutation(int idx, int N, int R, int[] arr) {
        if (idx == R) {
            print(R, arr);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (marked[i]) continue;
            marked[i] = true;
            arr[idx] = i;
            permutation(idx + 1, N, R, arr);
            marked[i] = false;

        }
    }

    static void print(int R, int[] arr) {
        for (int i = 0; i < R; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append("\n");
    }
}

