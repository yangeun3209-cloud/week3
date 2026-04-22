package week8.abs_class;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle("Red", 5);
        shapes[1] = new Rectangle("Blue", 4, 6);

        for (Shape shape : shapes) {
            System.out.println("면적: " + shape.getArea());
            System.out.println("둘레: " + shape.getPerimeter());
        }
    }
}