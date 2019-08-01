import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Valet {
    private List<ParkingLot> parkingLots;
    private Map<Receipt, ParkingLot> receiptParkingLotMap = new HashMap<>();

    public Valet(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt parkCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            Receipt receipt = parkingLot.push(car);
            if(receipt != null){
                receiptParkingLotMap.put(receipt, parkingLot);
                return receipt;
            }
        }
        return null;
    }

    public Car pickUpCar(Receipt receipt) {
        ParkingLot parkingLot = receiptParkingLotMap.get(receipt);
        if (parkingLot == null) return null;
        return parkingLot.pop(receipt);
    }
}
