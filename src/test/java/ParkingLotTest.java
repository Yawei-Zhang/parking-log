import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldReturnReceiptWhenPushCarGivenAParkingLotWith1SpaceAndACarToPark() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        Receipt receipt = parkingLot.push(car);

        assertNotNull(receipt);
    }

    @Test
    public void shouldReturnNullWhenPushCarGivenAParkingLotWithNoSpaceAndACarToPark() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.push(car1);

        Receipt receipt = parkingLot.push(car2);

        assertNull(receipt);
    }

    @Test
    public void shouldReturnCarWhenPopCarGivenAParkingLotWith1SpaceAndACarToLeave() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.push(car);

        Car actualCar = parkingLot.pop(receipt);
        assertEquals(car, actualCar);
    }

    @Test
    public void shouldReturnNullWhenPopCarGivenAParkingLotWithACarParkingAndIllegalReceipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt receipt = new Receipt();

        Car car = parkingLot.pop(receipt);
        assertNull(car);
    }

    @Test
    public void shouldReturnReceiptWhenPushPopPushCarGivenAParkingLotWith1SpaceAndACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        Receipt receipt1 = parkingLot.push(car);
        parkingLot.pop(receipt1);
        Receipt receipt2 = parkingLot.push(car);

        assertNotNull(receipt2);
    }

    @Test
    public void shouldReturnMyCarWhenPopCarGivenAParkingLotWithAnotherCarsInIt() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car anotherCar = new Car();
        Car myCar = new Car();

        parkingLot.push(anotherCar);
        Receipt receipt2 = parkingLot.push(myCar);

        Car actualCar = parkingLot.pop(receipt2);

        assertEquals(myCar, actualCar);
        assertNotEquals(anotherCar, myCar);
    }
}