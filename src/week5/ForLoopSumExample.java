public class ForLoopSumExample {
    public static void main(String[] args) {
        // for 반복문: 초기화, 조건, 증감식이 한 줄에 명확하게 표현됨
        // 구조: for (초기화; 조건; 증감식)
        
        int sum = 0;
        
        // 1부터 10까지 반복
        for (int i = 1; i <= 10; i++) {
            sum += i;  // 각 숫자를 합에 더함
        }
        
        System.out.println("=== for 반복문을 이용한 합계 ===");
        System.out.println("1부터 10까지의 합: " + sum);
    }
}
