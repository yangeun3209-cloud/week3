package week6;

public class Book {
    String title;
    int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public void print(String type) {
        System.out.println(type + ": 제목: " + title + ", 가격: " + price + "원");
    }
}