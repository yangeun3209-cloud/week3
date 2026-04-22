package week08.inf_advenced;

/**
 * AutonomousVehicle: ElectricVehicle을 확장하여 자율주행 기능 추가
 */
public interface AutonomousVehicle extends ElectricVehicle {
    void selfDrive(); // 자율주행 시작
}