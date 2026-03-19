public class Main {
    public static void main(String[] args) {
        System.out.println("boolean: 1 bytes");
        System.out.println("byte: " + (Byte.SIZE / 8) + " bytes");
        System.out.println("short: " + (Short.SIZE / 8) + " bytes");
        System.out.println("int: " + (Integer.SIZE / 8) + " bytes");
        System.out.println("long: " + (Long.SIZE / 8) + " bytes");
        System.out.println("float: " + (Float.SIZE / 8) + " bytes");
        System.out.println("double: " + (Double.SIZE / 8) + " bytes");
        System.out.println("char: " + (Character.SIZE / 8) + " bytes");

        // int 타입의 최댓값과 최솟값 출력
        System.out.println("int 최대값: " + Integer.MAX_VALUE);
        System.out.println("int 최소값: " + Integer.MIN_VALUE);

        // long 타입의 최댓값과 최솟값 출력
        System.out.println("long 최대값: " + Long.MAX_VALUE);
        System.out.println("long 최소값: " + Long.MIN_VALUE);

        // double 타입의 최댓값과 최솟값 출력
        System.out.println("double 최대값: " + Double.MAX_VALUE);
        System.out.println("double 최소값: " + Double.MIN_VALUE);
    }
}