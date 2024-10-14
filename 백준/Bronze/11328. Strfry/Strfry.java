import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean flag;
        int[] arr;
        while (N-- > 0) {
            flag = true;
            arr = new int[26];
            String s1 = sc.next();
            String s2 = sc.next();

            for (int i = 0; i < s1.length(); i++) {
                arr[s1.charAt(i)-'a']++;
            }
            for (int i = 0; i < s2.length(); i++) {
                arr[s2.charAt(i)-'a']--;
            }
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }

    }
}
