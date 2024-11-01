import java.util.*;

public class Main {
    static Object[] sortedArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] initArr = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            initArr[i] = sc.nextInt();
            set.add(initArr[i]);
        }
        sortedArr = set.toArray();
        Arrays.sort(sortedArr);

        for (int i = 0; i < N; i++) {
            int target = initArr[i];
            sb.append(binarySearch(target)).append(" ");
        }
        System.out.println(sb);
    }

    /**
     *
     * @param target 목표 value
     * @return target의 index값
     */
    private static int binarySearch(int target) {
        int index = -1;
        int start = 0;
        int end = sortedArr.length-1;
        while (start <= end) {
            int mid = (start + end) / 2 ;
            if(target == (Integer)sortedArr[mid]){
                index = mid;
                break;
            } else if (target < (Integer)sortedArr[mid]) {
              end = mid-1;
            } else{
                start = mid+1;
            }

        }
        return index;
    }
}