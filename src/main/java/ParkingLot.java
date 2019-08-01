import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Integer capacity;
    private Map<Receipt, Car> carMap = new HashMap<>();

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public Receipt push(Car car) {
        if(carMap.size() >= capacity){
            return null;
        }
        Receipt receipt = new Receipt();
        carMap.put(receipt, car);
        return receipt;
    }

    public Car pop(Receipt receipt) {
        return carMap.remove(receipt);
    }
}
