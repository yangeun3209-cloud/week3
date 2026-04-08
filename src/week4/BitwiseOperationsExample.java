package week4;

//비트 연산 실습
public class BitwiseOperationsExample {
    public static void main(String[] args) {
        System.out.println("=== Java 비트 연산 예제 ===\n");
        
        // 두 정수 선언
        int a = 10;  // 이진수: 1010
        int b = 12;  // 이진수: 1100
        
        System.out.println("두 정수:");
        System.out.println("a = " + a + " (이진수: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (이진수: " + Integer.toBinaryString(b) + ")");
        System.out.println();
        
        // 1. 비트 AND 연산 (&)
        int andResult = a & b;
        System.out.println("1. 비트 AND 연산 (a & b)");
        System.out.println("   " + Integer.toBinaryString(a) + " & " + Integer.toBinaryString(b) + " = " + Integer.toBinaryString(andResult));
        System.out.println("   10진수 결과: " + andResult);
        System.out.println();
        
        // 2. 비트 OR 연산 (|)
        int orResult = a | b;
        System.out.println("2. 비트 OR 연산 (a | b)");
        System.out.println("   " + Integer.toBinaryString(a) + " | " + Integer.toBinaryString(b) + " = " + Integer.toBinaryString(orResult));
        System.out.println("   10진수 결과: " + orResult);
        System.out.println();
        
        // 3. 비트 XOR 연산 (^)
        int xorResult = a ^ b;
        System.out.println("3. 비트 XOR 연산 (a ^ b)");
        System.out.println("   " + Integer.toBinaryString(a) + " ^ " + Integer.toBinaryString(b) + " = " + Integer.toBinaryString(xorResult));
        System.out.println("   10진수 결과: " + xorResult);
        System.out.println();
        
        // 4. 비트 NOT 연산 (~) - a에 대해
        int notResultA = ~a;
        System.out.println("4. 비트 NOT 연산 (~a)");
        System.out.println("   ~" + Integer.toBinaryString(a) + " = " + Integer.toBinaryString(notResultA));
        System.out.println("   10진수 결과: " + notResultA);
        System.out.println();
        
        // 5. 비트 NOT 연산 (~) - b에 대해
        int notResultB = ~b;
        System.out.println("5. 비트 NOT 연산 (~b)");
        System.out.println("   ~" + Integer.toBinaryString(b) + " = " + Integer.toBinaryString(notResultB));
        System.out.println("   10진수 결과: " + notResultB);
        System.out.println();
        
        // 추가 설명
        System.out.println("=== 비트 연산 설명 ===");
        System.out.println("• AND (&): 두 비트가 모두 1일 때 1");
        System.out.println("• OR (|): 두 비트 중 하나라도 1일 때 1");
        System.out.println("• XOR (^): 두 비트가 다를 때 1");
        System.out.println("• NOT (~): 비트를 반전 (0→1, 1→0)");
    }
}