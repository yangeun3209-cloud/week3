public class RaggedArrayExample {
    public static void main(String[] args) {
        // ragged 배열(비정형 2차원 배열) 생성
        // 각 행마다 열의 개수가 서로 다름
        int[][] raggedArray = {
                {10, 20, 30},
                {40, 50},
                {60, 70, 80, 90},
                {100}
        };

        System.out.println("=== ragged 배열(비정형 2차원 배열) 예제 ===");

        // 각 행의 length 출력
        System.out.println("각 행의 열 크기(length):");
        for (int i = 0; i < raggedArray.length; i++) {
            System.out.println(i + "번 행의 length = " + raggedArray[i].length);
        }

        System.out.println("\n이중 for문으로 전체 요소 출력:");
        // 이중 for문으로 모든 요소 출력
        for (int i = 0; i < raggedArray.length; i++) {
            System.out.println("[" + i + "번 행]");
            for (int j = 0; j < raggedArray[i].length; j++) {
                System.out.println("raggedArray[" + i + "][" + j + "] = " + raggedArray[i][j]);
            }
            System.out.println();
        }
    }
}
