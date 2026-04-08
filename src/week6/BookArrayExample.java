package week6;

public class BookArrayExample {
    public static void main(String[] args) {

        System.out.println("=== 책 정보 ===");

        // 원본 배열
        Book[] orgBooks = {
                new Book("자바 완벽 가이드", 35000),
                new Book("이펙티브 자바", 32000),
                new Book("자바 알고리즘", 28000)
        };

        // 수정 배열 (가격 증가)
        Book[] updBooks = {
                new Book("자바 완벽 가이드", 38500),
                new Book("이펙티브 자바", 35200),
                new Book("자바 알고리즘", 30800)
        };

        // Org 출력
        for (Book b : orgBooks) {
            b.print("Org");
        }

        // Upd 출력
        for (Book b : updBooks) {
            b.print("Upd");
        }

        System.out.println();

        // 숫자 배열
        int[] org = {1, 2, 3, 4, 5};
        int[] upd = {1, 2, 3};

        for (int i : org) {
            System.out.println("Org: " + i);
        }

        for (int i : upd) {
            System.out.println("Upd: " + i);
        }
    }
}