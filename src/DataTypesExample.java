public class DataTypesExample {
    public static void main(String[] args) {
        // Boolean 타입
        boolean isJavaFun = true;
        System.out.println("Boolean: " + isJavaFun);

        // Byte 타입
        byte smallNumber = 127;
        System.out.println("Byte: " + smallNumber);

        // Short 타입
        short shortNumber = 32767;
        System.out.println("Short: " + shortNumber);

        // Int 타입
        int integerNumber = 2147483647;
        System.out.println("Int: " + integerNumber);

        // Long 타입
        long longNumber = 9223372036854775807L;
        System.out.println("Long: " + longNumber);

        // Float 타입
        float floatNumber = 3.14f;
        System.out.println("Float: " + floatNumber);

        // Double 타입
        double doubleNumber = 3.141592653589793;
        System.out.println("Double: " + doubleNumber);

        // Char 타입
        char letter = 'A';
        System.out.println("Char: " + letter);

        // String 타입 (참조 타입)
        String greeting = "Hello, Java!";
        System.out.println("String: " + greeting);

        // 변수 연산 예제
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println("Sum of " + a + " and " + b + " is: " + sum);

        double pi = 3.14;
        double radius = 5.0;
        double area = pi * radius * radius;
        System.out.println("Area of circle with radius " + radius + " is: " + area);
    }
}