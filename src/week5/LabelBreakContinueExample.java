public class LabelBreakContinueExample {
    public static void main(String[] args) {
        System.out.println("=== Label 없는 버전 ===");
        noLabelExample();

        System.out.println("\n=== Label 있는 버전 ===");
        withLabelExample();
    }

    // Label 없는 버전: break와 continue는 내부 루프에만 적용됨
    public static void noLabelExample() {
        for (int i = 0; i < 3; i++) {
            System.out.println("외부 루프 i = " + i);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("  내부 루프에서 break (i=1, j=1)");
                    break;  // 내부 루프만 탈출
                }
                System.out.println("  내부 루프 j = " + j);
            }
        }
        System.out.println("외부 루프 종료");

        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println("외부 루프 i = " + i);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("  내부 루프에서 continue (i=1, j=1)");
                    continue;  // 내부 루프의 다음 반복으로
                }
                System.out.println("  내부 루프 j = " + j);
            }
        }
        System.out.println("외부 루프 종료");
    }

    // Label 있는 버전: break와 continue가 label이 가리키는 외부 루프에 적용됨
    public static void withLabelExample() {
        outerBreak: for (int i = 0; i < 3; i++) {
            System.out.println("외부 루프 i = " + i);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("  내부 루프에서 break outerBreak (i=1, j=1)");
                    break outerBreak;  // 외부 루프 탈출
                }
                System.out.println("  내부 루프 j = " + j);
            }
        }
        System.out.println("외부 루프 종료");

        System.out.println();

        outerContinue: for (int i = 0; i < 3; i++) {
            System.out.println("외부 루프 i = " + i);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("  내부 루프에서 continue outerContinue (i=1, j=1)");
                    continue outerContinue;  // 외부 루프의 다음 반복으로
                }
                System.out.println("  내부 루프 j = " + j);
            }
        }
        System.out.println("외부 루프 종료");
    }
}

/*
=== Label 없는 버전 ===
외부 루프 i = 0
  내부 루프 j = 0
  내부 루프 j = 1
  내부 루프 j = 2
외부 루프 i = 1
  내부 루프 j = 0
  내부 루프에서 break (i=1, j=1)
외부 루프 i = 2
  내부 루프 j = 0
  내부 루프 j = 1
  내부 루프 j = 2
외부 루프 종료

외부 루프 i = 0
  내부 루프 j = 0
  내부 루프 j = 1
  내부 루프 j = 2
외부 루프 i = 1
  내부 루프 j = 0
  내부 루프에서 continue (i=1, j=1)
  내부 루프 j = 2
외부 루프 i = 2
  내부 루프 j = 0
  내부 루프 j = 1
  내부 루프 j = 2
외부 루프 종료

=== Label 있는 버전 ===
외부 루프 i = 0
  내부 루프 j = 0
  내부 루프 j = 1
  내부 루프 j = 2
외부 루프 i = 1
  내부 루프 j = 0
  내부 루프에서 break outerBreak (i=1, j=1)
외부 루프 종료

외부 루프 i = 0
  내부 루프 j = 0
  내부 루프 j = 1
  내부 루프 j = 2
외부 루프 i = 1
  내부 루프 j = 0
  내부 루프에서 continue outerContinue (i=1, j=1)
외부 루프 i = 2
  내부 루프 j = 0
  내부 루프 j = 1
  내부 루프 j = 2
외부 루프 종료
*/