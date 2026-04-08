package week6;

public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order("ORD-1001", 15000);
        Order order2 = new Order("ORD-1002", 23000);
        Order order3 = new Order("ORD-1003", 12000);

        System.out.println("생성된 주문");
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);

        System.out.println();
        System.out.println("주문 통계");
        System.out.println("총 주문 수: " + OrderStats.getTotalCount());
        System.out.println("총 주문 금액: " + OrderStats.getTotalAmount());
        System.out.println("평균 주문 금액: " + OrderStats.getAverageAmount());
    }
}
