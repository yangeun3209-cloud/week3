package week4;

// 강제 형변환 실습
public class ForceCastingExample {
    public static void main(String[] args) {
        System.out.println("=== Java 강제형변환(Casting) 예제 ===\n");
        
        // 1. double -> int 강제형변환 (소수점 손실)
        System.out.println("1. double -> int 강제형변환 (소수점 손실)");
        System.out.println("----------------------------------------");
        double doubleValue1 = 123.456;
        int intValue1 = (int) doubleValue1;  // 강제형변환
        System.out.println("원본 double 값: " + doubleValue1);
        System.out.println("강제형변환 후 int 값: " + intValue1);
        System.out.println("손실된 소수점: " + (doubleValue1 - intValue1));
        System.out.println();
        
        // 2. double -> int 강제형변환 (음수)
        System.out.println("2. double -> int 강제형변환 (음수)");
        System.out.println("----------------------------------------");
        double doubleValue2 = -456.789;
        int intValue2 = (int) doubleValue2;  // 강제형변환
        System.out.println("원본 double 값: " + doubleValue2);
        System.out.println("강제형변환 후 int 값: " + intValue2);
        System.out.println("손실된 소수점: " + Math.abs(doubleValue2 - intValue2));
        System.out.println();
        
        // 3. int -> byte 강제형변환 (오버플로우로 인한 데이터 손실)
        System.out.println("3. int -> byte 강제형변환 (오버플로우)");
        System.out.println("----------------------------------------");
        int intValue3 = 300;
        byte byteValue1 = (byte) intValue3;  // 강제형변환
        System.out.println("원본 int 값: " + intValue3);
        System.out.println("byte 범위: -128 ~ 127");
        System.out.println("강제형변환 후 byte 값: " + byteValue1);
        System.out.println("데이터 손실 발생!");
        System.out.println();
        
        // 4. int -> byte 강제형변환 (음수 오버플로우)
        System.out.println("4. int -> byte 강제형변환 (음수 오버플로우)");
        System.out.println("----------------------------------------");
        int intValue4 = -200;
        byte byteValue2 = (byte) intValue4;  // 강제형변환
        System.out.println("원본 int 값: " + intValue4);
        System.out.println("byte 범위: -128 ~ 127");
        System.out.println("강제형변환 후 byte 값: " + byteValue2);
        System.out.println("데이터 손실 발생!");
        System.out.println();
        
        // 5. int -> byte 강제형변환 (범위 내 값)
        System.out.println("5. int -> byte 강제형변환 (범위 내 값)");
        System.out.println("----------------------------------------");
        int intValue5 = 100;
        byte byteValue3 = (byte) intValue5;  // 강제형변환
        System.out.println("원본 int 값: " + intValue5);
        System.out.println("byte 범위: -128 ~ 127");
        System.out.println("강제형변환 후 byte 값: " + byteValue3);
        System.out.println("데이터 손실 없음!");
        System.out.println();
        
        // 비교 요약
        System.out.println("=== 강제형변환 요약 ===");
        System.out.println("• double -> int: 소수점 부분이 버려짐");
        System.out.println("• int -> byte: 범위를 초과하면 오버플로우로 인해 데이터 손실 발생");
        System.out.println("             범위: -128 ~ 127");
    }
}