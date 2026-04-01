public class PrimeNumberExample {
    public static void main(String[] args) {
        // 100 이하의 소수 중에서 10개만 출력
        int count = 0;
        int limit = 10;  // 출력할 소수의 개수
        
        System.out.println("=== 100 이하의 소수 (10개만 출력) ===");
        
        // 2부터 100까지 반복
        for (int num = 2; num <= 100 && count < limit; num++) {
            // 소수 판별
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
        }
        System.out.println();
    }
    
    // 소수 판별 메서드
    public static boolean isPrime(int num) {
        // 1보다 작거나 같으면 소수가 아님
        if (num <= 1) {
            return false;
        }
        
        // 2는 소수
        if (num == 2) {
            return true;
        }
        
        // 짝수는 소수가 아님
        if (num % 2 == 0) {
            return false;
        }
        
        // 3부터 num의 제곱근까지 홀수로 나누어떨어지는지 확인
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
