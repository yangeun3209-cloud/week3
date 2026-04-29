public class StringCollection {
    public static void main(String[] args) {
        String intStr = "123";
        String doubleStr = "3.14";
        String booleanStr = "true";

        try {
            int intParse = Integer.parseInt(intStr);
            Integer intValueOf = Integer.valueOf(intStr);

            double doubleParse = Double.parseDouble(doubleStr);
            Double doubleValueOf = Double.valueOf(doubleStr);

            boolean booleanParse = Boolean.parseBoolean(booleanStr);
            Boolean booleanValueOf = Boolean.valueOf(booleanStr);

            System.out.println("=== int 변환 ===");
            System.out.println("parseInt 값: " + intParse + ", 타입: int");
            System.out.println("valueOf 값: " + intValueOf + ", 타입: Integer");
            System.out.println("== 비교: " + (intParse == intValueOf));
            System.out.println("equals 비교: " + intValueOf.equals(intParse));

            System.out.println();

            System.out.println("=== double 변환 ===");
            System.out.println("parseDouble 값: " + doubleParse + ", 타입: double");
            System.out.println("valueOf 값: " + doubleValueOf + ", 타입: Double");
            System.out.println("== 비교: " + (doubleParse == doubleValueOf));
            System.out.println("equals 비교: " + doubleValueOf.equals(doubleParse));

            System.out.println();

            System.out.println("=== boolean 변환 ===");
            System.out.println("parseBoolean 값: " + booleanParse + ", 타입: boolean");
            System.out.println("valueOf 값: " + booleanValueOf + ", 타입: Boolean");
            System.out.println("== 비교: " + (booleanParse == booleanValueOf));
            System.out.println("equals 비교: " + booleanValueOf.equals(booleanParse));

        } catch (NumberFormatException e) {
            System.out.println("숫자 변환 중 오류 발생: " + e.getMessage());
        }
    }
}