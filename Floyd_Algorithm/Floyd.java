package Floyd_Algorithm;

public class Floyd {
    private static int INF = 1000;
    private static int path[][] = {
            {0, 2, 3, INF, INF},
            {2, 0, INF, INF, 10},
            {3, INF, 0, 1, 4},
            {INF, INF, 1, 0, 2},
            {INF, 10, 4, 2, 0}
    };

    public static void main(String[] args) {
        print();
        floydAlgorithm();
        System.out.println();
        System.out.println();
        print();
    }

    public static void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (path[i][j] == INF) {
                    System.out.print(" INF");
                    continue; // 다음 반복을 이어나가기
                }
                System.out.printf("%4d", path[i][j]);
            }
            System.out.println();
        }
    }

    public static void floydAlgorithm() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (path[i][j] > path[i][k] + path[k][j]) {
                        path[i][j] = path[i][k] + path[k][j];
                    }
                }
            }
        }
    }
}

