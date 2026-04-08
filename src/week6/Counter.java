package week6;

public class Counter {
    private static int count = 100;

    public Counter() {
        count++;
    }

    public static void printCount() {
        System.out.println("현재 공유 count 값: " + count);
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("객체 생성 전 count 값");
        Counter.printCount();

        Counter c1 = new Counter();
        System.out.println("첫 번째 객체 생성 후");
        Counter.printCount();

        Counter c2 = new Counter();
        System.out.println("두 번째 객체 생성 후");
        Counter.printCount();

        Counter c3 = new Counter();
        System.out.println("세 번째 객체 생성 후");
        Counter.printCount();

        System.out.println("c1에서 본 count: " + c1.getCount());
        System.out.println("c2에서 본 count: " + c2.getCount());
        System.out.println("c3에서 본 count: " + c3.getCount());
    }
}
