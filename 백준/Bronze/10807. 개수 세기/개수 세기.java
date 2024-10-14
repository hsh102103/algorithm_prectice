import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[201];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            arr[num+100]++;
        }

        int target = sc.nextInt();
        System.out.println(arr[target+100]);

    }
}
