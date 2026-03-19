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
    }
}