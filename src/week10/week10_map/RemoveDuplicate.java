package week10.week10_map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicate {

    // 방법 1: 일반적인 방법 (중첩 반복문 이용)
    public static int[] removeByGeneral(int[] arr) {
        int[] temp = new int[arr.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[count] = arr[i];
                count++;
            }
        }

        // 새로운 배열에 중복이 제거된 데이터만 복사
        int[] result = new int[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    // 방법 2: HashSet을 이용한 중복제거
    public static int[] removeByHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] originalArray = new int[20];

        // 20개의 정수 배열에 0~10까지의 무작위 값 저장
        System.out.println("========== 원본 배열 ==========");
        for (int i = 0; i < 20; i++) {
            originalArray[i] = random.nextInt(11); // 0~10까지의 난수
        }
        System.out.println(Arrays.toString(originalArray));
        System.out.println("배열 크기: " + originalArray.length);

        // 방법 1: 일반적인 방법으로 중복제거
        System.out.println("\n========== 방법 1: 일반적인 방법 (중첩 반복문) ==========");
        long startTime1 = System.nanoTime();
        int[] resultGeneral = removeByGeneral(originalArray);
        long endTime1 = System.nanoTime();
        long timeGeneral = endTime1 - startTime1;

        System.out.println("중복 제거된 배열: " + Arrays.toString(resultGeneral));
        System.out.println("결과 배열 크기: " + resultGeneral.length);
        System.out.println("실행시간: " + timeGeneral + " 나노초 (" + (timeGeneral / 1000.0) + " 마이크로초)");

        // 방법 2: HashSet을 이용한 중복제거
        System.out.println("\n========== 방법 2: HashSet을 이용한 중복제거 ==========");
        long startTime2 = System.nanoTime();
        int[] resultHashSet = removeByHashSet(originalArray);
        long endTime2 = System.nanoTime();
        long timeHashSet = endTime2 - startTime2;

        System.out.println("중복 제거된 배열: " + Arrays.toString(resultHashSet));
        System.out.println("결과 배열 크기: " + resultHashSet.length);
        System.out.println("실행시간: " + timeHashSet + " 나노초 (" + (timeHashSet / 1000.0) + " 마이크로초)");

        // 성능 비교
        System.out.println("\n========== 성능 비교 ==========");
        System.out.println("일반적인 방법: " + timeGeneral + " ns");
        System.out.println("HashSet 방법: " + timeHashSet + " ns");
        if (timeGeneral > timeHashSet) {
            System.out.println("HashSet이 " + ((double) timeGeneral / timeHashSet) + "배 더 빠릅니다.");
        } else {
            System.out.println("일반적인 방법이 " + ((double) timeHashSet / timeGeneral) + "배 더 빠릅니다.");
        }
    }
}
