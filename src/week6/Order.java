package week6;

public class Order {
    private String id;
    private int amount;

    private static int totalCount = 0;
    private static int totalAmount = 0;

    public Order(String id, int amount) {
        this.id = id;
        this.amount = amount;

        totalCount++;
        totalAmount += amount;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public static int getTotalCountValue() {
        return totalCount;
    }

    public static int getTotalAmountValue() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order{id='" + id + "', amount=" + amount + "}";
    }
}
