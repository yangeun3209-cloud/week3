package week3;

public class ByteOverflowExample {
    public static void main(String[] args) {
        // byte 타입의 범위: -128 ~ 127 (8비트 signed integer)
        // 127은 byte의 최대값임
        
        byte b = 127;  // byte 타입 변수에 최대값 127 저장
        System.out.println("초기값: b = " + b);
        
        // 1을 더하면 128이 되지만, byte 범위를 초과하므로 오버플로우 발생
        // 오버플로우: 128 → -128 (2의 보수 표현에서 순환)
        b = (byte) (b + 1);  // 강제 형변환 필요 (int + byte → int)
        System.out.println("127 + 1 = " + b);
        
        // 왜 -128이 나오는가?
        // byte는 8비트: 01111111 (127) + 1 = 10000000 (-128, 2의 보수)
        // 이는 이진수에서 최상위 비트가 부호 비트로 사용되기 때문
        
        System.out.println("\n=== 설명 ===");
        System.out.println("byte 범위: -128 ~ 127");
        System.out.println("127 + 1 = 128 (범위 초과)");
        System.out.println("오버플로우로 인해 -128로 순환");
        System.out.println("이진수: 01111111(127) + 1 = 10000000(-128)");
    }
}