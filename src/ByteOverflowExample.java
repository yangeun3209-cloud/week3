public class ByteOverflowExample {
    public static void main(String[] args) {
        // byte 타입은 8비트로, 범위가 -128 ~ 127입니다.
        // 127에 1을 더하면 최대값을 초과하여 오버플로우가 발생합니다.
        // 이진수로 01111111 (127) + 1 = 10000000 (-128, 2의 보수 표현)
        byte b = 127;
        b = (byte) (b + 1);
        System.out.println("127 + 1 = " + b); // -128 출력

        // -128에서 1을 빼면 최소값을 초과하여 언더플로우가 발생합니다.
        // 이진수로 10000000 (-128) - 1 = 01111111 (127, 2의 보수 표현)
        byte c = -128;
        c = (byte) (c - 1);
        System.out.println("-128 - 1 = " + c); // 127 출력
    }
}