public class DoWhileLoopSumExample {
    public static void main(String[] args) {
        // do-while 반복문: 루프 본문을 먼저 실행한 후 조건을 검사함
        // 구조: do { 실행문; } while (조건);
        // 특징: 조건의 참/거짓과 상관없이 최소 1회 이상 실행됨
        
        int sum = 0;
        int i = 1;  // 초기화: do-while 반복문 밖에서 수행
        
        // 1부터 10까지 반복 (먼저 실행한 후 조건 확인)
        do {
            sum += i;  // 각 숫자를 합에 더함
            i++;       // 증감식: 반복문 내부에서 수행
        } while (i <= 10);  // 조건을 마지막에 검사
        
        System.out.println("=== do-while 반복문을 이용한 합계 ===");
        System.out.println("1부터 10까지의 합: " + sum);
    }
}
