import java.util.Scanner;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] map;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int targetNum = sc.nextInt();
        int r = N/2;
        int c = N/2;

        map = new int[N][N];

        map[r][c] = 1;
        search(r,c);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == targetNum){
                    System.out.println((i+1) +" "+(j+1));
                    return;
                }
            }
        }
    }
    static int num =2;

    static void search(int r, int c){
        int cnt = 0;
        int d = 0;
        while(cnt != 4){
            int nr = dr[d % 4] + r;
            int nc = dc[d % 4] + c;
            if (isNotRange(nr, nc) || map[nr][nc] != 0) {
                d--;
                cnt++;
                continue;
            }
            map[nr][nc] = num++;
            cnt=0;
            r=nr;
            c=nc;
            d++;
        }
    }
    static boolean isNotRange(int r, int c){
        return r>=N || c>=N || r<0 || c<0;
    }
}

