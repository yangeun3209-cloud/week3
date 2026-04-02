//증감 및 삼항 연산자 실습
public class OperatorsExample {
    public static void main(String[] args) {
        System.out.println("=== Java 연산자 예제 ===\n");
        
        // 1. 전위 증감(++a)과 후위 증감(a++) 연산자의 차이 비교
        System.out.println("1. 전위 증감(++a)과 후위 증감(a++) 연산자의 차이");
        System.out.println("------------------------------------------------");
        
        int a = 5;
        int b = 5;
        
        System.out.println("초기값: a = " + a + ", b = " + b);
        System.out.println();
        
        // 후위 증감: 값이 먼저 사용된 후 증가
        System.out.println("후위 증감 (a++):");
        System.out.println("int result1 = a++;");
        int result1 = a++;
        System.out.println("result1 = " + result1 + ", a = " + a);
        System.out.println();
        
        // 전위 증감: 값이 먼저 증가된 후 사용
        System.out.println("전위 증감 (++b):");
        System.out.println("int result2 = ++b;");
        int result2 = ++b;
        System.out.println("result2 = " + result2 + ", b = " + b);
        System.out.println();
        
        // 비교 요약
        System.out.println("=== 차이점 요약 ===");
        System.out.println("• 후위 증감(a++): 현재 값을 먼저 반환한 후 1 증가");
        System.out.println("• 전위 증감(++a): 1 증가한 후 새로운 값을 반환");
        System.out.println();
        
        // 2. 삼항 연산자를 이용해 두 수 중 큰 값 구하기
        System.out.println("2. 삼항 연산자를 이용해 두 수 중 큰 값 구하기");
        System.out.println("---------------------------------------------");
        
        int num1 = 10;
        int num2 = 20;
        
        System.out.println("두 수: num1 = " + num1 + ", num2 = " + num2);
        
        // 삼항 연산자: (조건) ? 참일 때 값 : 거짓일 때 값
        int max = (num1 > num2) ? num1 : num2;
        System.out.println("삼항 연산자: int max = (num1 > num2) ? num1 : num2;");
        System.out.println("결과: max = " + max);
        System.out.println();
        
        // 다른 예제들
        int x = 15, y = 15;
        int max2 = (x > y) ? x : y;
        System.out.println("예제2: x = " + x + ", y = " + y + " → max = " + max2 + " (같은 경우)");
        
        int p = 7, q = 12;
        int max3 = (p > q) ? p : q;
        System.out.println("예제3: p = " + p + ", q = " + q + " → max = " + max3);
        
        System.out.println();
        System.out.println("=== 삼항 연산자 설명 ===");
        System.out.println("• 구문: (조건식) ? 참_값 : 거짓_값");
        System.out.println("• if-else 문의 간단한 형태");
        System.out.println("• 두 값 중 하나를 선택할 때 유용");
    }
}