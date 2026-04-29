import java.util.ArrayList;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<String>();

        // 학생 5명 추가
        students.add("김철수");
        students.add("이영희");
        students.add("박민수");
        students.add("최지우");
        students.add("정하늘");

        System.out.println("=== 학생 5명 추가 후 전체 출력 ===");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + "번 인덱스: " + students.get(i));
        }

        // 3번 인덱스 수정
        int updateIndex = 3;
        if (updateIndex >= 0 && updateIndex < students.size()) {
            students.set(updateIndex, "홍길동");
        }

        // 1번 인덱스 삭제
        int removeIndex = 1;
        if (removeIndex >= 0 && removeIndex < students.size()) {
            students.remove(removeIndex);
        }

        System.out.println();
        System.out.println("=== 수정 및 삭제 후 결과 출력 ===");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + "번 인덱스: " + students.get(i));
        }
    }
}