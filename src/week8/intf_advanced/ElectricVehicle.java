package week08.inf_advenced;

/**
 * ElectricVehicle: Vehicle을 확장하여 전기차 관련 기능 추가
 */
public interface ElectricVehicle extends Vehicle {
    void charge(int amount); // 충전 (amount 퍼센트 증가)
    int getBatteryLevel();   // 배터리 잔량(0-100)
}
