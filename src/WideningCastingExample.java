public class WideningCastingExample {
    public static void main(String[] args) {
        System.out.println("=== Java 자동 타입 변환 (Widening) 예제 ===");
        System.out.println("순서: byte → short → int → long → float → double\n");
        
        // 1단계: byte 값 선언
        byte byteValue = 10;
        System.out.println("1단계) byte 타입");
        System.out.println("   byte byteValue = " + byteValue);
        System.out.println("   타입: " + getTypeName(byteValue));
        System.out.println();
        
        // 2단계: byte → short 자동 변환
        short shortValue = byteValue;  // 자동 변환 (byte → short)
        System.out.println("2단계) byte → short 자동 변환");
        System.out.println("   short shortValue = byteValue;");
        System.out.println("   short shortValue = " + shortValue);
        System.out.println("   타입: " + getTypeName(shortValue));
        System.out.println();
        
        // 3단계: short → int 자동 변환
        int intValue = shortValue;  // 자동 변환 (short → int)
        System.out.println("3단계) short → int 자동 변환");
        System.out.println("   int intValue = shortValue;");
        System.out.println("   int intValue = " + intValue);
        System.out.println("   타입: " + getTypeName(intValue));
        System.out.println();
        
        // 4단계: int → long 자동 변환
        long longValue = intValue;  // 자동 변환 (int → long)
        System.out.println("4단계) int → long 자동 변환");
        System.out.println("   long longValue = intValue;");
        System.out.println("   long longValue = " + longValue);
        System.out.println("   타입: " + getTypeName(longValue));
        System.out.println();
        
        // 5단계: long → float 자동 변환
        float floatValue = longValue;  // 자동 변환 (long → float)
        System.out.println("5단계) long → float 자동 변환");
        System.out.println("   float floatValue = longValue;");
        System.out.println("   float floatValue = " + floatValue);
        System.out.println("   타입: " + getTypeName(floatValue));
        System.out.println();
        
        // 6단계: float → double 자동 변환
        double doubleValue = floatValue;  // 자동 변환 (float → double)
        System.out.println("6단계) float → double 자동 변환");
        System.out.println("   double doubleValue = floatValue;");
        System.out.println("   double doubleValue = " + doubleValue);
        System.out.println("   타입: " + getTypeName(doubleValue));
        System.out.println();
        
        // 최종 결과
        System.out.println("=== 최종 결과 ===");
        System.out.println("원본 byte 값: " + byteValue);
        System.out.println("최종 double 값: " + doubleValue);
    }
    
    // 값의 타입을 문자열로 반환하는 헬퍼 메서드
    static String getTypeName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}