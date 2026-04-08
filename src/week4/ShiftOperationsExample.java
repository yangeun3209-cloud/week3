package week4;

//시프트 연산 실습
public class ShiftOperationsExample {
    public static void main(String[] args) {
        System.out.println("=== Java 시프트 연산 예제 ===\n");

        // 양수 값
        int positive = 10;  // 이진수: 1010
        System.out.println("양수 값: " + positive + " (이진수: " + Integer.toBinaryString(positive) + ")");
        System.out.println();

        // 음수 값
        int negative = -10;  // 이진수: 2의 보수 형태
        System.out.println("음수 값: " + negative + " (이진수: " + Integer.toBinaryString(negative) + ")");
        System.out.println();

        // 왼쪽 시프트 (<<) - 양수
        System.out.println("=== 왼쪽 시프트 (<<) - 양수 ===");
        for (int shift = 1; shift <= 3; shift++) {
            int result = positive << shift;
            System.out.println("10 << " + shift + " = " + result + " (이진수: " + Integer.toBinaryString(result) + ")");
        }
        System.out.println();

        // 왼쪽 시프트 (<<) - 음수
        System.out.println("=== 왼쪽 시프트 (<<) - 음수 ===");
        for (int shift = 1; shift <= 3; shift++) {
            int result = negative << shift;
            System.out.println("-10 << " + shift + " = " + result + " (이진수: " + Integer.toBinaryString(result) + ")");
        }
        System.out.println();

        // 오른쪽 시프트 (>>) - 양수
        System.out.println("=== 오른쪽 시프트 (>>) - 양수 ===");
        for (int shift = 1; shift <= 3; shift++) {
            int result = positive >> shift;
            System.out.println("10 >> " + shift + " = " + result + " (이진수: " + Integer.toBinaryString(result) + ")");
        }
        System.out.println();

        // 오른쪽 시프트 (>>) - 음수
        System.out.println("=== 오른쪽 시프트 (>>) - 음수 (부호 유지) ===");
        for (int shift = 1; shift <= 3; shift++) {
            int result = negative >> shift;
            System.out.println("-10 >> " + shift + " = " + result + " (이진수: " + Integer.toBinaryString(result) + ")");
        }
        System.out.println();

        // 부호 없는 오른쪽 시프트 (>>>) - 양수
        System.out.println("=== 부호 없는 오른쪽 시프트 (>>>) - 양수 ===");
        for (int shift = 1; shift <= 3; shift++) {
            int result = positive >>> shift;
            System.out.println("10 >>> " + shift + " = " + result + " (이진수: " + Integer.toBinaryString(result) + ")");
        }
        System.out.println();

        // 부호 없는 오른쪽 시프트 (>>>) - 음수
        System.out.println("=== 부호 없는 오른쪽 시프트 (>>>) - 음수 (부호 무시) ===");
        for (int shift = 1; shift <= 3; shift++) {
            int result = negative >>> shift;
            System.out.println("-10 >>> " + shift + " = " + result + " (이진수: " + Integer.toBinaryString(result) + ")");
        }
        System.out.println();

        // 음수에서 >>와 >>>의 차이 강조
        System.out.println("=== 음수에서 >>와 >>>의 차이 ===");
        int shiftAmount = 2;
        int rightShift = negative >> shiftAmount;
        int unsignedRightShift = negative >>> shiftAmount;
        System.out.println("원본 음수: " + negative + " (이진수: " + Integer.toBinaryString(negative) + ")");
        System.out.println("-10 >> " + shiftAmount + " = " + rightShift + " (이진수: " + Integer.toBinaryString(rightShift) + ") - 부호 유지");
        System.out.println("-10 >>> " + shiftAmount + " = " + unsignedRightShift + " (이진수: " + Integer.toBinaryString(unsignedRightShift) + ") - 부호 무시");
        System.out.println("차이: >>는 부호 비트를 유지하지만 >>>는 0으로 채움");
        System.out.println();

        // 시프트 연산 설명
        System.out.println("=== 시프트 연산 설명 ===");
        System.out.println("• 왼쪽 시프트 (<<): 비트를 왼쪽으로 이동, 오른쪽은 0으로 채움 (값 × 2^shift)");
        System.out.println("• 오른쪽 시프트 (>>): 비트를 오른쪽으로 이동, 왼쪽은 부호 비트로 채움 (값 ÷ 2^shift)");
        System.out.println("• 부호 없는 오른쪽 시프트 (>>>): 비트를 오른쪽으로 이동, 왼쪽은 0으로 채움");
    }
}

