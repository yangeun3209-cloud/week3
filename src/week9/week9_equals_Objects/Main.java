
public class Main {
    public static void main(String[] args) {
        // Test Case 1: 동일 ID의 객체 비교
        System.out.println("=== Test Case 1: 동일 ID 객체 비교 ===");
        Student s1 = new Student(1, "김철수");
        Student s2 = new Student(1, "김철수");
        Student s3 = new Student(1, "다른이름");

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
        System.out.println();

        System.out.println("s1 == s2: " + (s1 == s2));  // false (다른 객체)
        System.out.println("s1.equals(s2): " + s1.equals(s2));  // true (id가 동일)
        System.out.println();

        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("s1.hashCode() == s2.hashCode(): " + (s1.hashCode() == s2.hashCode()));
        System.out.println();

        System.out.println("s1 == s3: " + (s1 == s3));  // false (다른 객체)
        System.out.println("s1.equals(s3): " + s1.equals(s3));  // true (id가 동일, name은 무관)
        System.out.println();

        // Test Case 2: 다른 ID의 객체 비교
        System.out.println("=== Test Case 2: 다른 ID 객체 비교 ===");
        Student s4 = new Student(2, "박영희");
        Student s5 = new Student(3, "박영희");

        System.out.println("s4: " + s4);
        System.out.println("s5: " + s5);
        System.out.println();

        System.out.println("s4 == s5: " + (s4 == s5));  // false
        System.out.println("s4.equals(s5): " + s4.equals(s5));  // false (id가 다름)
        System.out.println();

        System.out.println("s4.hashCode(): " + s4.hashCode());
        System.out.println("s5.hashCode(): " + s5.hashCode());
        System.out.println("s4.hashCode() == s5.hashCode(): " + (s4.hashCode() == s5.hashCode()));
        System.out.println();

        // Test Case 3: hashCode 먼저 비교
        System.out.println("=== Test Case 3: hashCode 비교 순서 ===");
        Student s6 = new Student(10, "학생10");
        Student s7 = new Student(10, "학생10");

        System.out.println("s6과 s7의 hashCode 동일성: " + (s6.hashCode() == s7.hashCode()));
        System.out.println("s6과 s7의 equals 결과: " + s6.equals(s7));
        System.out.println("(equals 호출 시 내부에서 hashCode 먼저 비교됨)");
        System.out.println();

        // Test Case 4: 다른 타입과의 비교
        System.out.println("=== Test Case 4: 다른 타입과의 비교 ===");
        Student s8 = new Student(1, "학생1");
        String str = "Student";

        System.out.println("s8.equals(str): " + s8.equals(str));  // false (타입 다름)
        System.out.println("s8.equals(null): " + s8.equals(null));  // false (null)
    }
}
