package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11404 {
    private static int[][] path;
    private static final int MAX_PATH = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.valueOf(st.nextToken());
        path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    path[i][j] = 0;
                else
                    path[i][j] = MAX_PATH;
            }
        }


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken()); // 시작
            int b = Integer.valueOf(st.nextToken()); // 도착
            int c = Integer.valueOf(st.nextToken()); // 처음 비용

            // MAX_PATH로 초기화 된 배열의 값들과 비교하여 초기 비용을 저장합니다.
            if (path[a][b] > c) {
                path[a][b] = c;
            }
        }

        floydAlgorithm(n);


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (path[i][j] == 10000001)
                    System.out.print("0 "); //i -> j로 갈 수 없는 경우 0출력
                else {
                    System.out.print(path[i][j]);
                    if (j < n) {
                        System.out.print(" ");
                    }
                }
            }
            if (i < n) {
                System.out.println();
            }
        }

    }

    public static void floydAlgorithm(int n) {
        for (int k = 1; k <= n; k++) { // 경유 지점
            for (int i = 1; i <= n; i++) { // 출발 지점
                if (k == i) {
                    continue;
                }
                for (int j = 1; j <= n; j++) { // 도착 지점
                    if (i == j || j == k) {
                        continue;
                    }
                    if (path[i][j] > path[i][k] + path[k][j]) {
                        path[i][j] = path[i][k] + path[k][j];
                    }
                }
            }
        }
    }
}