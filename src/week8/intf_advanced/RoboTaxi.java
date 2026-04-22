package week08.inf_advenced;

/**
 * RoboTaxi 클래스는 AutonomousVehicle을 구현한다.
 */
public class RoboTaxi implements AutonomousVehicle {
    private final String id;
    private int batteryLevel;

    public RoboTaxi(String id) {
        this.id = id;
        this.batteryLevel = 100; // 초기 배터리
    }

    @Override
    public void move() {
        System.out.println("[RoboTaxi " + id + "] Moving to destination. Battery=" + batteryLevel + "%");
        batteryLevel = Math.max(0, batteryLevel - 5);
    }

    @Override
    public void stop() {
        System.out.println("[RoboTaxi " + id + "] Stopped.");
    }

    @Override
    public void charge(int amount) {
        batteryLevel = Math.min(100, batteryLevel + amount);
        System.out.println("[RoboTaxi " + id + "] Charging by " + amount + "%. Battery=" + batteryLevel + "%");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void selfDrive() {
        System.out.println("[RoboTaxi " + id + "] Engaging self-drive mode.");
        batteryLevel = Math.max(0, batteryLevel - 10);
    }
}
