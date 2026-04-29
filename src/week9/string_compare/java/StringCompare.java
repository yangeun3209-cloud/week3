package week9.string_compare.java;

public class StringCompare {
    public static void main(String[] args) {

        // 1. String equals() 와 compareTo() 비교
        String str1 = "apple";
        String str2 = "apple";
        String str3 = "banana";

        System.out.println("=== equals 비교 ===");
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));

        System.out.println();

        System.out.println("=== compareTo 비교 ===");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2));
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3));
        System.out.println("str3.compareTo(str1): " + str3.compareTo(str1));

        System.out.println();

        // 2. String 객체 내용 변경 여부
        String s = "Hello";
        s = s + " World";   // 기존 객체 변경 X, 새 객체 생성

        System.out.println("=== String 변경 예 ===");
        System.out.println(s);

        // String은 immutable(불변 객체)
        // 직접 내용 변경 불가
        // 예: s[0] = 'h';  // 오류

        System.out.println();

        // 3. StringBuffer 주요 메서드
        StringBuffer sb = new StringBuffer("Java");

        System.out.println("=== StringBuffer ===");

        sb.append(" Programming");
        System.out.println("append: " + sb);

        sb.insert(5, "Language ");
        System.out.println("insert: " + sb);

        sb.delete(5, 14);
        System.out.println("delete: " + sb);

        sb.reverse();
        System.out.println("reverse: " + sb);
    }
}