package week10.filereader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyProgram {

    public static void main(String[] args) {
        // Scanner를 통해 입력 파일명 받기
        Scanner scanner = new Scanner(System.in);
        String inputFileName = null;
        String outputFileName = "out.txt";

        try {
            System.out.println("========== 파일 복사 프로그램 ==========");
            System.out.print("복사할 텍스트 파일명을 입력하세요: ");
            inputFileName = scanner.nextLine().trim();

            // 입력 파일명 유효성 검사
            if (inputFileName.isEmpty()) {
                System.out.println("오류: 파일명을 입력해주세요.");
                return;
            }

            System.out.println("\n파일 복사 진행 중...");
            System.out.println("입력 파일: " + inputFileName);
            System.out.println("출력 파일: " + outputFileName);

            // try-with-resources를 이용한 FileReader와 FileWriter 자동 종료
            try (FileReader reader = new FileReader(inputFileName);
                 FileWriter writer = new FileWriter(outputFileName)) {

                int charCode;
                int charCount = 0;

                // FileReader로 1자씩 읽기
                while ((charCode = reader.read()) != -1) {
                    // FileWriter로 쓰기
                    writer.write(charCode);
                    charCount++;
                }

                System.out.println("\n✓ 파일 복사 완료!");
                System.out.println("복사된 문자 수: " + charCount + "개");

            } catch (IOException e) {
                // 파일 미존재 또는 기타 IO 예외 처리
                if (e.getMessage().contains("존재하지 않습니다") || 
                    e.getMessage().contains("No such file")) {
                    System.out.println("\n✗ 오류: 입력 파일 '" + inputFileName + "'이(가) 존재하지 않습니다.");
                } else if (e.getMessage().contains("Permission denied")) {
                    System.out.println("\n✗ 오류: 파일 접근 권한이 없습니다.");
                } else {
                    System.out.println("\n✗ 오류: 파일 처리 중 오류가 발생했습니다.");
                    System.out.println("상세 내용: " + e.getMessage());
                }
            }

        } finally {
            // Scanner 종료
            scanner.close();
            System.out.println("\n========== 프로그램 종료 ==========");
        }
    }
}
