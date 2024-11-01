import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] originArr = new int[N];
        int[] sortedArr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            originArr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = originArr[i];
        }
        Arrays.sort(sortedArr);
        int rank = 0;
        for(int i: sortedArr) {
            if(!map.containsKey(i)) {
                map.put(i, rank++);
            }
        }

        for(int i: originArr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}