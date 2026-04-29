package weeko9.string_compare;

public class StringBufferExample {
    public static void main(String[] args) {
        // StringBuffer 객체 생성
        StringBuffer sb = new StringBuffer("Java");

        // 1. append: 뒤에 문자열 추가
        sb.append(" Programming");
        System.out.println("append 결과: " + sb); // "Java Programming"

        // 2. insert: 특정 위치에 문자열 삽입
        sb.insert(5, "Is ");
        System.out.println("insert 결과: " + sb); // "Java Is Programming"

        // 3. delete: 특정 범위의 문자열 삭제 (시작 인덱스부터 끝 인덱스 전까지)
        sb.delete(5, 8);
        System.out.println("delete 결과: " + sb); // "Java Programming"

        // 4. reverse: 문자열 순서를 뒤집음
        sb.reverse();
        System.out.println("reverse 결과: " + sb); // "gnimmargorP avaJ"
    }
}