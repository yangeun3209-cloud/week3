package week6;

public class AppConfig {
    static String APP_NAME = initAppName();
    static String DB_HOST = initDbHost();
    static int DB_PORT = initDbPort();
    static String DB_NAME = initDbName();
    static String CONNECTION_STRING;

    static {
        System.out.println("5) static 초기화 블록 실행 시작");

        CONNECTION_STRING = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
        System.out.println("6) 연결 문자열 조합 완료: " + CONNECTION_STRING);

        validateConfig();
        System.out.println("7) 유효성 검사 완료");
    }

    private static String initAppName() {
        System.out.println("1) APP_NAME 선언 시 초기화");
        return "MyApp";
    }

    private static String initDbHost() {
        System.out.println("2) DB_HOST 선언 시 초기화");
        return "localhost";
    }

    private static int initDbPort() {
        System.out.println("3) DB_PORT 선언 시 초기화");
        return 3306;
    }

    private static String initDbName() {
        System.out.println("4) DB_NAME 선언 시 초기화");
        return "myappdb";
    }

    private static void validateConfig() {
        if (APP_NAME == null || APP_NAME.isBlank()) {
            throw new IllegalStateException("APP_NAME은 비어 있을 수 없습니다.");
        }

        if (DB_HOST == null || DB_HOST.isBlank()) {
            throw new IllegalStateException("DB_HOST는 비어 있을 수 없습니다.");
        }

        if (DB_PORT <= 0 || DB_PORT > 65535) {
            throw new IllegalStateException("DB_PORT는 1~65535 범위여야 합니다.");
        }

        if (DB_NAME == null || DB_NAME.isBlank()) {
            throw new IllegalStateException("DB_NAME은 비어 있을 수 없습니다.");
        }
    }

    public static void printConfig() {
        System.out.println("APP_NAME: " + APP_NAME);
        System.out.println("DB_HOST: " + DB_HOST);
        System.out.println("DB_PORT: " + DB_PORT);
        System.out.println("DB_NAME: " + DB_NAME);
        System.out.println("CONNECTION_STRING: " + CONNECTION_STRING);
    }

    public static void main(String[] args) {
        System.out.println("main() 시작 - AppConfig 클래스는 이미 로딩 및 초기화 완료");
        printConfig();
    }
}
