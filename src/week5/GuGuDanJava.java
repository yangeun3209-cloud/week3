public class GuGuDanJava {
    public static void main(String[] args) {
        // 2차원 배열 생성: 2단부터 9단까지(8행), 각 단의 1~9 곱셈 결과(9열)
        int[][] gugudan = new int[8][9];

        // 이중 for문으로 구구단 결과를 배열에 저장
        for (int i = 0; i < gugudan.length; i++) {
            for (int j = 0; j < gugudan[i].length; j++) {
                gugudan[i][j] = (i + 2) * (j + 1);
            }
        }

        System.out.println("=== for문으로 구구단 출력 ===");
        // 인덱스를 직접 사용하므로 몇 단, 몇 번째 곱셈인지 명확하게 표현 가능
        for (int i = 0; i < gugudan.length; i++) {
            System.out.println("[" + (i + 2) + "단]");
            for (int j = 0; j < gugudan[i].length; j++) {
                System.out.println((i + 2) + " x " + (j + 1) + " = " + gugudan[i][j]);
            }
            System.out.println();
        }

        System.out.println("=== for-each문으로 구구단 출력 ===");
        // for-each문은 값을 꺼내는 데 집중할 수 있지만 인덱스가 없으므로 별도 변수로 단과 곱하는 수를 관리
        int dan = 2;
        for (int[] row : gugudan) {
            System.out.println("[" + dan + "단]");
            int multiplier = 1;
            for (int value : row) {
                System.out.println(dan + " x " + multiplier + " = " + value);
                multiplier++;
            }
            dan++;
            System.out.println();
        }
    }
}
