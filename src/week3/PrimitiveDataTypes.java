//기본 데이터 타입 실습
package week3;

public class PrimitiveDataTypes {
    public static void main(String[] args) {
        System.out.println("=== Java 기본 데이터 타입 (8가지) ===");
        System.out.println("이름\t\t메모리 크기 (byte)");
        System.out.println("--------------------------------");
        System.out.println("byte\t\t1");
        System.out.println("short\t\t2");
        System.out.println("int\t\t4");
        System.out.println("long\t\t8");
        System.out.println("float\t\t4");
        System.out.println("double\t\t8");
        System.out.println("char\t\t2");
        System.out.println("boolean\t\t1");
        System.out.println();
        System.out.println("=== 참고 ===");
        System.out.println("• boolean 타입은 JVM에 따라 1비트로 최적화될 수 있지만, 일반적으로 1바이트 할당");
        System.out.println("• char 타입은 UTF-16 인코딩을 사용하므로 2바이트");
    }
}