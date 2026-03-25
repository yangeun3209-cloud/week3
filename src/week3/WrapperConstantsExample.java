package week3;

public class WrapperConstantsExample {
    public static void main(String[] args) {
        System.out.println("=== Java Wrapper 클래스 상수 - 최댓값과 최솟값 ===");
        System.out.println();
        
        // int 타입의 최댓값과 최솟값
        System.out.println("int 타입:");
        System.out.println("  Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("  Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println();
        
        // long 타입의 최댓값과 최솟값
        System.out.println("long 타입:");
        System.out.println("  Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("  Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println();
        
        // double 타입의 최댓값과 최솟값
        System.out.println("double 타입:");
        System.out.println("  Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("  Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println();
        
        // 추가 정보
        System.out.println("=== 참고 사항 ===");
        System.out.println("• Integer.MIN_VALUE: " + Integer.MIN_VALUE + " (int의 음수 최솟값)");
        System.out.println("• Long.MIN_VALUE: " + Long.MIN_VALUE + " (long의 음수 최솟값)");
        System.out.println("• Double.MIN_VALUE: " + Double.MIN_VALUE + " (double에서 표현 가능한 가장 작은 양수 값)");
        System.out.println("• Double의 음수 최솟값은 -Double.MAX_VALUE와 같음: " + (-Double.MAX_VALUE));
        System.out.println();
        
        // 실수 타입의 특수 값들
        System.out.println("=== double의 특수 값들 ===");
        System.out.println("  Double.POSITIVE_INFINITY = " + Double.POSITIVE_INFINITY);
        System.out.println("  Double.NEGATIVE_INFINITY = " + Double.NEGATIVE_INFINITY);
        System.out.println("  Double.NaN = " + Double.NaN);
    }
}