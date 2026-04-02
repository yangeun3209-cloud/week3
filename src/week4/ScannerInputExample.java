// Scanner 입력 실습
import java.util.Scanner;

public class ScannerInputExample {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 사용자 정보 입력 프로그램 ===");
        
        // 1. 이름 입력 (String) - nextLine() 사용
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        
        // 2. 나이 입력 (int) - nextInt() 사용
        System.out.print("나이를 입력하세요: ");
        int age = scanner.nextInt();
        
        // 3. 키 입력 (double) - nextDouble() 사용
        System.out.print("키를 입력하세요 (cm): ");
        double height = scanner.nextDouble();
        
        // 입력 받은 정보 출력
        System.out.println("\n=== 입력된 정보 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "세");
        System.out.println("키: " + height + "cm");
        
        // Scanner 닫기
        scanner.close();
    }
}