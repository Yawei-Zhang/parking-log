public class Application {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(100);

        Car car1 = new Car();
        Receipt receipt = parkingLot.push(car1);

        Car carPicked1 = parkingLot.pop(receipt);
        if(car1.equals(carPicked1)){
            System.out.println("Picking Up Successful");
        }
        else{
            System.out.println("Picking Up Failed");
        }
    }
}
