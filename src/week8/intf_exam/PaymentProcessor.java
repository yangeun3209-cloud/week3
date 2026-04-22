package week08.inf_advanced;

/**
 * ========================================
 * Java 인터페이스의 Default, Static, Private 메소드 비교
 * ========================================
 *
 * 【역사와 도입 배경】
 *
 * 1. Default 메소드 (Java 8, 2014)
 *    - 도입 배경: 기존 인터페이스에 새로운 메소드를 추가할 때,
 *               모든 구현체를 수정해야 하는 문제 해결
 *    - 예시: Iterable에 forEach() 추가 (Collections 프레임워크 확장)
 *    - 특징: 구현체에서 선택적으로 오버라이드 가능
 *
 * 2. Static 메소드 (Java 8, 2014)
 *    - 도입 배경: 유틸리티 성 헬퍼 메소드를 인터페이스 내에 직접 정의
 *               팩토리 메소드 등 유틸리티를 인터페이스와 함께 제공
 *    - 예시: Collections.emptyList() → List.of() 같은 팩토리 메소드
 *    - 특징: 인스턴스 필요 없이 InterfaceName.method()로 호출
 *
 * 3. Private 메소드 (Java 9, 2017)
 *    - 도입 배경: default/static 메소드 간 코드 중복을 제거하기 위한
 *               공통 헬퍼 메소드가 필요 (외부 노출 불필요)
 *    - 특징: 같은 인터페이스 내에서만 호출 가능
 *           구현체에서는 접근 불가능
 *
 * ========================================
 */

/**
 * 실무 예시: 결제 시스템 (PaymentProcessor)
 *
 * 이 인터페이스는:
 * - static 메소드: 환율 변환, 통화 검증 등 유틸리티
 * - default 메소드: 결제 처리, 로깅 등 기본 로직
 * - private 메소드: 검증, 포맷팅 등 내부 헬퍼 로직
 *
 * private 메소드가 default/static 메소드의 반복되는 로직을 통합
 */
public interface PaymentProcessor {
    // ============ 추상 메소드 ============
    void processPayment(double amount, String currency);

    // ============ STATIC 메소드 (유틸리티) ============
    /**
     * Static 메소드: 환율 변환
     * - 인스턴스 불필요
     * - 호출: PaymentProcessor.convertCurrency(100, "USD", "KRW")
     */
    static double convertCurrency(double amount, String from, String to) {
        // 외부 API 호출 시뮬레이션 (실제로는 환율 API 사용)
        double conversionRate = getConversionRate(from, to);
        double converted = amount * conversionRate;

        // private 메소드 호출
        validateAmount(converted);
        return converted;
    }

    /**
     * Static 메소드: 결제 가능 여부 확인
     */
    static boolean isPaymentAllowed(String paymentMethod) {
        return validatePaymentMethod(paymentMethod);
    }

    // ============ DEFAULT 메소드 (기본 로직) ============
    /**
     * Default 메소드: 결제 처리 + 로깅
     * - 구현체에서 선택적으로 오버라이드 가능
     * - private 메소드를 호출하여 공통 로직 재사용
     */
    default void executePayment(double amount, String currency, String paymentMethod) {
        // private 메소드로 검증 (외부에서 직접 호출 불가)
        validatePaymentInput(amount, currency, paymentMethod);

        // 포맷팅된 금액 가져오기 (private 메소드 사용)
        String formattedAmount = formatCurrency(amount, currency);

        // 결제 실행
        processPayment(amount, currency);

        // 로깅 (private 메소드)
        logTransaction(formattedAmount, paymentMethod, "SUCCESS");
    }

    /**
     * Default 메소드: 결제 취소 + 환불 처리
     */
    default void refundPayment(double amount, String currency, String reason) {
        // 환불 금액 검증
        validateRefundAmount(amount);

        // 환불 처리
        System.out.println("💸 환불 처리 중: " + formatCurrency(amount, currency));

        // 로깅
        logTransaction(formatCurrency(amount, currency), "REFUND", reason);
    }

    /**
     * Default 메소드: 거래 내역 조회
     */
    default void printTransactionSummary(double amount, String currency) {
        System.out.println("=== 거래 요약 ===");
        System.out.println("금액: " + formatCurrency(amount, currency));
        System.out.println("상태: 완료");
    }

    // ============ PRIVATE 메소드 (내부 헬퍼) ============
    /**
     * Private 메소드: 결제 입력값 검증
     * default executePayment()와 다른 메소드에서 공통으로 사용
     * → 코드 중복 제거
     */
    private void validatePaymentInput(double amount, String currency, String paymentMethod) {
        // private 메소드 호출 (헬퍼 메소드)
        validateAmount(amount);
        validateCurrency(currency);
        validatePaymentMethod(paymentMethod);
        System.out.println("✅ 입력값 검증 완료");
    }

    /**
     * Private 메소드: 금액 검증
     * - static 메소드 convertCurrency()와 default 메소드에서 모두 사용
     * - 공통 로직 통합
     */
    private static void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("금액은 0보다 커야 합니다: " + amount);
        }
        if (amount > 1_000_000) {
            throw new IllegalArgumentException("일일 한도 초과: " + amount);
        }
    }

    /**
     * Private 메소드: 통화 검증
     */
    private void validateCurrency(String currency) {
        if (currency == null || currency.length() != 3) {
            throw new IllegalArgumentException("유효하지 않은 통화: " + currency);
        }
    }

    /**
     * Private 메소드: 환불 금액 검증
     */
    private void validateRefundAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("환불 금액은 0보다 커야 합니다");
        }
    }

    /**
     * Private Static 메소드: 결제 방식 검증
     * static 메소드와 private 메소드 결합 사용
     */
    private static boolean validatePaymentMethod(String method) {
        return method.equals("CREDIT_CARD") ||
                method.equals("DEBIT_CARD") ||
                method.equals("BANK_TRANSFER");
    }

    /**
     * Private Static 메소드: 환율 조회
     * static convertCurrency()에서 호출
     */
    private static double getConversionRate(String from, String to) {
        // 환율 테이블 (실제로는 API 호출)
        if (from.equals("USD") && to.equals("KRW")) return 1300.0;
        if (from.equals("EUR") && to.equals("KRW")) return 1400.0;
        return 1.0;
    }

    /**
     * Private 메소드: 통화 포맷팅
     * default 메소드들에서 반복 사용되는 로직 통합
     */
    private String formatCurrency(double amount, String currency) {
        return String.format("%.2f %s", amount, currency);
    }

    /**
     * Private 메소드: 거래 로깅
     * 모든 거래 메소드에서 공통으로 사용
     */
    private void logTransaction(String amount, String method, String status) {
        System.out.println("📝 로그: [" + java.time.LocalTime.now() + "] " +
                amount + " | " + method + " | " + status);
    }
}
