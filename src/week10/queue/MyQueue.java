package week10.queue;

import java.util.ArrayList;
import java.util.Iterator;

public class MyQueue<T> {
    private ArrayList<T> queue;

    // 생성자
    public MyQueue() {
        queue = new ArrayList<>();
    }

    // enqueue: 큐의 rear에 요소 추가
    public void enqueue(T element) {
        queue.add(element);
    }

    // dequeue: 큐의 front에서 요소 제거 및 반환
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return null;
        }
        return queue.remove(0);
    }

    // peek: 큐의 front 요소 확인 (제거하지 않음)
    public T peek() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return null;
        }
        return queue.get(0);
    }

    // isEmpty: 큐가 비어있는지 확인
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // size: 큐의 크기 반환
    public int size() {
        return queue.size();
    }

    // 큐의 모든 요소를 문자열로 반환
    @Override
    public String toString() {
        return queue.toString();
    }

    // Iterator를 이용하여 큐의 내용을 출력
    public void printQueueState() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return;
        }

        System.out.print("큐의 내용 [Front] -> ");
        Iterator<T> iterator = queue.iterator();
        
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" -> [Rear]");
    }

    // main 메서드
    public static void main(String[] args) {
        System.out.println("========== MyQueue 테스트 (ArrayList 기반, Iterator 활용) ==========\n");

        // 1. Integer 타입의 MyQueue 테스트
        System.out.println("【 Integer 타입 MyQueue 】");
        MyQueue<Integer> intQueue = new MyQueue<>();

        System.out.println("--- enqueue 작업 ---");
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);
        intQueue.enqueue(40);
        intQueue.enqueue(50);

        System.out.println("enqueue 완료: 10, 20, 30, 40, 50");
        intQueue.printQueueState();
        System.out.println("큐 크기: " + intQueue.size());

        System.out.println("\n--- peek 작업 ---");
        System.out.println("Front 요소 (peek): " + intQueue.peek());
        System.out.println("큐 크기: " + intQueue.size() + " (변화 없음)");

        System.out.println("\n--- dequeue 작업 (2개) ---");
        System.out.println("dequeue: " + intQueue.dequeue());
        System.out.println("dequeue: " + intQueue.dequeue());
        intQueue.printQueueState();
        System.out.println("큐 크기: " + intQueue.size());

        System.out.println("\n--- isEmpty 확인 ---");
        System.out.println("isEmpty: " + intQueue.isEmpty());

        System.out.println("\n--- 모든 요소 dequeue ---");
        while (!intQueue.isEmpty()) {
            System.out.println("dequeue: " + intQueue.dequeue());
        }
        intQueue.printQueueState();
        System.out.println("isEmpty: " + intQueue.isEmpty());

        // 2. String 타입의 MyQueue 테스트
        System.out.println("\n\n【 String 타입 MyQueue 】");
        MyQueue<String> stringQueue = new MyQueue<>();

        System.out.println("--- enqueue 작업 ---");
        stringQueue.enqueue("Apple");
        stringQueue.enqueue("Banana");
        stringQueue.enqueue("Cherry");
        stringQueue.enqueue("Date");
        stringQueue.enqueue("Elderberry");

        System.out.println("enqueue 완료: Apple, Banana, Cherry, Date, Elderberry");
        stringQueue.printQueueState();
        System.out.println("큐 크기: " + stringQueue.size());

        System.out.println("\n--- peek 작업 ---");
        System.out.println("Front 요소 (peek): " + stringQueue.peek());
        System.out.println("큐 크기: " + stringQueue.size() + " (변화 없음)");

        System.out.println("\n--- dequeue 작업 (2개) ---");
        System.out.println("dequeue: " + stringQueue.dequeue());
        System.out.println("dequeue: " + stringQueue.dequeue());
        stringQueue.printQueueState();
        System.out.println("큐 크기: " + stringQueue.size());

        System.out.println("\n--- isEmpty 확인 ---");
        System.out.println("isEmpty: " + stringQueue.isEmpty());

        System.out.println("\n--- 모든 요소 dequeue ---");
        while (!stringQueue.isEmpty()) {
            System.out.println("dequeue: " + stringQueue.dequeue());
        }
        stringQueue.printQueueState();
        System.out.println("isEmpty: " + stringQueue.isEmpty());

        System.out.println("\n========== 테스트 완료 ==========");
    }
}
