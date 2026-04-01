public class WhileLoopSumExample {
    public static void main(String[] args) {
        // while 반복문: 루프 시작 전에 조건을 검사함
        // 구조: while (조건) { 실행문; }
        // 특징: 초기화와 증감식이 반복문 외부에 있음
        
        int sum = 0;
        int i = 1;  // 초기화: while 반복문 밖에서 수행
        
        // 1부터 10까지 반복 (조건을 먼저 확인)
        while (i <= 10) {
            sum += i;  // 각 숫자를 합에 더함
            i++;       // 증감식: 반복문 내부에서 수행
        }
        
        System.out.println("=== while 반복문을 이용한 합계 ===");
        System.out.println("1부터 10까지의 합: " + sum);
    }
}
