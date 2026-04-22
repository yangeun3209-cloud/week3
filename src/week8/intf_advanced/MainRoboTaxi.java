package week08.inf_advenced;

/**
 * Main 클래스: Vehicle, ElectricVehicle, AutonomousVehicle 타입으로 참조하여
 * 각 타입에서 접근 가능한 메서드 범위를 비교하는 예시
 */
public class MainRoboTaxi {
    public static void main(String[] args) {
        RoboTaxi taxi = new RoboTaxi("RT-01");

        System.out.println("=== Referenced as Vehicle ===");
        Vehicle v = taxi;
        v.move();
        v.stop();
        // v.charge(...) // 컴파일 오류: Vehicle에는 charge가 없음

        System.out.println("\n=== Referenced as ElectricVehicle ===");
        ElectricVehicle ev = taxi;
        ev.move();
        ev.charge(15);
        System.out.println("Battery after charge: " + ev.getBatteryLevel() + "%");

        System.out.println("\n=== Referenced as AutonomousVehicle ===");
        AutonomousVehicle av = taxi;
        av.selfDrive();
        System.out.println("Battery after selfDrive: " + av.getBatteryLevel() + "%");
    }
}
