package week10.week10_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StudentMapIter {
    private HashMap<String, Integer> students;
    private Scanner scanner;

    public StudentMapIter() {
        students = new HashMap<>();
        scanner = new Scanner(System.in);
        initializeData();
    }

    // 초기 데이터 5명 입력
    private void initializeData() {
        students.put("김철수", 85);
        students.put("이영희", 92);
        students.put("박민수", 78);
        students.put("정수진", 88);
        students.put("최현준", 95);
    }

    // 메뉴 표시
    private void displayMenu() {
        System.out.println("\n========== 학생 점수 관리 프로그램 ==========");
        System.out.println("1. 모든 학생 조회");
        System.out.println("2. 특정 학생 점수 조회");
        System.out.println("3. 학생 점수 수정");
        System.out.println("4. 새로운 학생 추가");
        System.out.println("5. 학생 삭제");
        System.out.println("6. 종료");
        System.out.print("원하는 작업을 선택하세요 (1-6): ");
    }

    // 모든 학생 조회 (Iterator<Map.Entry> 사용)
    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\n등록된 학생이 없습니다.");
            return;
        }

        System.out.println("\n========== 전체 학생 성적 ==========");
        Iterator<Map.Entry<String, Integer>> iterator = students.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue() + "점");
        }
    }

    // 특정 학생 점수 조회
    private void searchStudent() {
        System.out.print("\n조회할 학생 이름을 입력하세요: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("이름을 입력해주세요.");
            return;
        }

        if (students.containsKey(name)) {
            System.out.println(name + "의 점수: " + students.get(name) + "점");
        } else {
            System.out.println("'" + name + "'에 해당하는 학생이 없습니다.");
        }
    }

    // 학생 점수 수정
    private void updateScore() {
        System.out.print("\n수정할 학생 이름을 입력하세요: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("이름을 입력해주세요.");
            return;
        }

        if (!students.containsKey(name)) {
            System.out.println("'" + name + "'에 해당하는 학생이 없습니다.");
            return;
        }

        System.out.print("새로운 점수를 입력하세요 (0-100): ");
        try {
            int score = Integer.parseInt(scanner.nextLine().trim());

            if (score < 0 || score > 100) {
                System.out.println("0 이상 100 이하의 점수를 입력해주세요.");
                return;
            }

            int oldScore = students.get(name);
            students.put(name, score);
            System.out.println(name + "의 점수가 수정되었습니다. (" + oldScore + "점 → " + score + "점)");
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력해주세요.");
        }
    }

    // 새로운 학생 추가
    private void addStudent() {
        System.out.print("\n추가할 학생 이름을 입력하세요: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("이름을 입력해주세요.");
            return;
        }

        if (students.containsKey(name)) {
            System.out.println("이미 등록된 학생입니다.");
            return;
        }

        System.out.print("점수를 입력하세요 (0-100): ");
        try {
            int score = Integer.parseInt(scanner.nextLine().trim());

            if (score < 0 || score > 100) {
                System.out.println("0 이상 100 이하의 점수를 입력해주세요.");
                return;
            }

            students.put(name, score);
            System.out.println(name + "이(가) 점수 " + score + "점으로 등록되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력해주세요.");
        }
    }

    // 학생 삭제
    private void deleteStudent() {
        System.out.print("\n삭제할 학생 이름을 입력하세요: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("이름을 입력해주세요.");
            return;
        }

        if (!students.containsKey(name)) {
            System.out.println("'" + name + "'에 해당하는 학생이 없습니다.");
            return;
        }

        students.remove(name);
        System.out.println(name + "이(가) 삭제되었습니다.");
    }

    // 프로그램 실행
    public void run() {
        System.out.println("========== 학생 점수 관리 프로그램 시작 ==========");

        while (true) {
            displayMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    displayAllStudents();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    updateScore();
                    break;
                case "4":
                    addStudent();
                    break;
                case "5":
                    deleteStudent();
                    break;
                case "6":
                    System.out.println("\n프로그램을 종료합니다. 감사합니다!");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 1~6 중에 선택해주세요.");
            }
        }
    }

    public static void main(String[] args) {
        StudentMapIter program = new StudentMapIter();
        program.run();
    }
}
