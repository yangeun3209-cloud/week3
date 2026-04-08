package week6;

public class Studnt2 {
    private String name;
    private int id;
    private String major;

    // 인스턴스 생성 시 공통 기본값 설정
    {
        name = "Unknown";
        id = 0;
        major = "Undeclared";
    }

    public Studnt2() {
        this("Unknown");
    }

    public Studnt2(String name) {
        this(name, 0);
    }

    public Studnt2(String name, int id) {
        this(name, id, "Undeclared");
    }

    public Studnt2(String name, int id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    public String thString() {
        return "[" + id + "] " + name + " (" + major + ")";
    }

    @Override
    public String toString() {
        return thString();
    }

    public static void main(String[] args) {
        Studnt2 s1 = new Studnt2();
        Studnt2 s2 = new Studnt2("Kim", 1001);
        Studnt2 s3 = new Studnt2("Lee", 1002, "Computer Science");

        System.out.println(s1.thString());
        System.out.println(s2.thString());
        System.out.println(s3.thString());
    }
}
