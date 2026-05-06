package week10.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamConverter {

    public static void main(String[] args) {
        // InputStream과 OutputStream 객체 생성
        InputStream input = new BufferedInputStream(System.in);
        OutputStream output = new BufferedOutputStream(System.out);

        try {
            output.write("========== 바이트 스트림 대문자 변환 프로그램 ==========\n".getBytes());
            output.write("텍스트를 입력하세요. 'q'를 입력하면 종료합니다.\n".getBytes());
            output.write("입력: ".getBytes());
            output.flush();

            int byteValue;

            // 바이트 단위로 읽기
            while ((byteValue = input.read()) != -1) {
                char ch = (char) byteValue;

                // 'q' 또는 'Q' 입력 시 종료
                if (ch == 'q' || ch == 'Q') {
                    output.write("\n프로그램을 종료합니다.\n".getBytes());
                    output.flush();
                    break;
                }

                // 개행 문자 처리
                if (ch == '\n') {
                    output.write('\n');
                    output.write("입력: ".getBytes());
                    output.flush();
                    continue;
                }

                // 엔터 문자는 처리하지 않음
                if (ch == '\r') {
                    continue;
                }

                // 소문자를 대문자로 변환하여 출력
                char upperChar = Character.toUpperCase(ch);
                output.write(upperChar);
                output.flush();
            }

            output.write("========== 프로그램 종료 ==========\n".getBytes());
            output.flush();

        } catch (IOException e) {
            System.err.println("입출력 오류 발생: " + e.getMessage());
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                System.err.println("스트림 종료 오류: " + e.getMessage());
            }
        }
    }
}
