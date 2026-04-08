package week6;

public class OrderStats {
    private OrderStats() {
    }

    public static double getAverageAmount() {
        if (getTotalCount() == 0) {
            return 0.0;
        }
        return (double) getTotalAmount() / getTotalCount();
    }

    public static int getTotalCount() {
        return Order.getTotalCountValue();
    }

    public static int getTotalAmount() {
        return Order.getTotalAmountValue();
    }
}
