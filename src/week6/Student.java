package week6;

public class Student {
    private String name;
    private int age;

    // 객체가 생성될 때 기본값을 먼저 설정한다.
    {
        name = "이름없음";
        age = 0;
    }

    public Student() {
        this("이름없음", 0);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}
