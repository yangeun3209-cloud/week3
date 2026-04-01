import java.util.Scanner;

public class ArrayDivisionMultiCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.println("=== 다중 catch 예외 처리 예제 ===");
            System.out.println("배열 값: 10, 20, 30, 40, 50");

            // 배열 인덱스를 입력받음
            System.out.print("접근할 배열 인덱스를 입력하세요: ");
            int index = scanner.nextInt();

            // 나눌 수를 입력받음
            System.out.print("나눌 수를 입력하세요: ");
            int divisor = scanner.nextInt();

            // 잘못된 인덱스를 입력하면 ArrayIndexOutOfBoundsException 발생 가능
            int value = numbers[index];

            // 0으로 나누면 ArithmeticException 발생 가능
            int result = value / divisor;

            System.out.println("numbers[" + index + "] = " + value);
            System.out.println(value + " / " + divisor + " = " + result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 범위를 벗어났습니다.");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } finally {
            System.out.println("처리 완료");
            scanner.close();
        }
    }
}
