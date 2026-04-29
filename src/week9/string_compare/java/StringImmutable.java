public class StringImmutable {
    public static void main(String[] args) {
        String original = "Hello";
        String modified = original.replace("H", "J");

        System.out.println("원본 문자열: " + original);
        System.out.println("변경된 문자열: " + modified);

        // String은 불변 객체이므로 original 값은 그대로 유지됨
    }
}