import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int nextNum = 1;
        for (int i = 0; i < N; i++) {
            int targetNum = sc.nextInt();
            while (true) {
                if (nextNum <= targetNum) {
                    stack.push(nextNum);
                    sb.append("+\n");
                    if (nextNum == targetNum) {
                        stack.pop();
                        sb.append("-\n");
                        nextNum++;
                        break;
                    }
                    nextNum++;
                } else {
                    if (stack.empty()) {
                        System.out.println("NO");
                        return;
                    }
                    int tmp = stack.pop();
                    sb.append("-\n");
                    if(tmp == targetNum ) break;
                }
            }

        }

        System.out.println(sb);
    }

    static Stack<Integer> stack = new Stack<>();
}

