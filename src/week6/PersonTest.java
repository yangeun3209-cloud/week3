package week6;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person("Kim", 20);

        // getter/setter를 통해 캡슐화된 필드에 접근
        person.setName("Lee");
        person.setAge(21);

        System.out.println("이름: " + person.getName());
        System.out.println("나이: " + person.getAge());
        System.out.println(person);

        // 아래 코드를 주석 해제하면 컴파일 오류가 발생한다.
        // 이유: name, age는 private 필드라 외부에서 직접 접근할 수 없다.
        // person.name = "Park"; // Error: name has private access in Person
        // person.age = 30;      // Error: age has private access in Person
    }
}
