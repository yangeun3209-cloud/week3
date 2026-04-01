public class OneDimArray {
    public static void main(String[] args) {
        // 1차원 정수 배열 선언·생성·초기화
        // 방법 1: 선언과 동시에 초기화
        int[] numbers = {10, 20, 30, 40, 50};

        // 방법 2: 선언 후 생성 및 초기화
        int[] scores = new int[5];
        scores[0] = 10;
        scores[1] = 20;
        scores[2] = 30;
        scores[3] = 40;
        scores[4] = 50;

        System.out.println("=== 1차원 배열 예제 ===");

        // for문으로 배열 순회
        System.out.println("for문으로 numbers 배열 순회:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // for-each문으로 배열 순회
        System.out.println("for-each문으로 scores 배열 순회:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        System.out.println("\n=== 2차원 배열 예제 ===");

        // 3×3 크기의 2차원 배열 생성
        int[][] matrix = new int[3][3];

        // 이중 for문으로 값 입력 (1부터 9까지)
        System.out.println("2차원 배열에 값 입력:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * 3 + j + 1;  // 1부터 9까지 순차적으로 입력
                System.out.print("matrix[" + i + "][" + j + "] = " + matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 이중 for문으로 값 출력
        System.out.println("\n2차원 배열 출력:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // for-each문으로 2차원 배열 출력 (고급)
        System.out.println("\nfor-each문으로 2차원 배열 출력:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}