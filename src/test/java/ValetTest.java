import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ValetTest {
    /**
     * Given 一个停车小弟 AND 一个容量为 1 的空停车场 AND 一辆车
     *
     * When 小弟停车
     *
     * Then 返回停车收据
     */
    @Test
    public void shouldReturnReceiptWhenValetParkCarGiven1EmptyParkingLotAndACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        Valet valet = new Valet(Arrays.asList(parkingLot));
        Car car = new Car();
        Receipt receipt = valet.parkCar(car);

        assertNotNull(receipt);
    }

    /**
     * Given 一个停车小弟 AND 一个容量为 1 的满停车场 AND 一辆车
     *
     * When 小弟停车
     *
     * Then 返回空
     */
    @Test
    public void shouldReturnNullWhenValetParkCarGivenAFullParkingLotAndACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        Valet valet = new Valet(Arrays.asList(parkingLot));
        valet.parkCar(car1);

        Receipt receipt = valet.parkCar(car2);

        assertNull(receipt);
    }

    /**
     * Given 一个停车小弟 AND 停有一辆车的停车场 AND 该车的收据
     *
     * When 小弟取车
     *
     * Then 返回该车
     */
    @Test
    public void shouldReturnCarWhenValetPickUpCarGivenAParkingLotWithACarInItAndThatCarReceipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Valet valet = new Valet(Arrays.asList(parkingLot));
        Receipt receipt = valet.parkCar(car);

        Car actualCar = valet.pickUpCar(receipt);
        assertEquals(actualCar, car);
    }

    /**
     *  Given 一个停车小弟 AND 停有一辆车的停车场 AND 其他收据
     *
     *  When 小弟取车
     *
     *  Then 返回空
     */
    @Test
    public void shouldReturnNullWhenValetPickUpCarGivenAParkingLotWithACarInItAndOtherReceipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Valet valet = new Valet(Arrays.asList(parkingLot));
        valet.parkCar(car);

        Receipt fakeReceipt = new Receipt();
        Car actualCar = valet.pickUpCar(fakeReceipt);

        assertNull(actualCar);
    }

    /**
     * Given 一个停车小弟
     *     AND 一个容量为 1 的满停车场
     *     AND 一个容量为 1 的空停车场 AND 一辆车
     *
     * When 小弟停车
     *
     * Then 返回收据
     */
    @Test
    public void shouldReturnReceiptWhenValetParkCarGivenAFullParkingLotAndAEmptyParkingLotAndACar() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Valet valet = new Valet(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        valet.parkCar(car1);

        Receipt receipt = valet.parkCar(car2);

        assertNotNull(receipt);
    }

    /**
     * Given 一个停车小弟 AND 两个容量为 1 的满停车场 AND 一辆车
     *
     * When 小弟停车
     *
     * Then 返回空收据
     */
    @Test
    public void shouldReturnNullGiven2FullParkingLotAndACar() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Valet valet = new Valet(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        valet.parkCar(car1);
        valet.parkCar(car2);

        Receipt receipt = valet.parkCar(car3);

        assertNull(receipt);
    }

    /**
     * Given 容量为 1 的满停车场（PL1）
     *     AND 容量为 1 的停车场（PL2）
     *     AND 容量为 1 的停车场（PL3）
     *     AND 停车小弟 (V1) 管理 PL1，PL2，PL3
     *     AND 停车小弟 （V2）管理 PL2
     *     AND 两辆车
     *
     * When 停车小弟 V1 先停车，然后停车小弟 V2 停车
     *
     * Then 停车小弟 V1 停车成功，返回收据，停车小弟 V2 停车失败，返回空收据
     */
    @Test
    public void shouldParkAtSecondParkingLotWhenParkCarGivenOneFullParkingLotAndTwoEmptyParkingLots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(1);
        Valet valet = new Valet(Arrays.asList(parkingLot1, parkingLot2, parkingLot3));
        Valet valet1 = new Valet(Arrays.asList(parkingLot1));
        Valet valet2 = new Valet(Arrays.asList(parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        valet1.parkCar(car1);
        valet.parkCar(car2);

        Receipt receipt = valet2.parkCar(car3);

        assertNull(receipt);
    }

    /**
     * Given 一个停车小弟
     *     AND 一个容量为 1 的满停车场(PL1)
     *     AND 一个容量为 1 的满停车场 (PL2)
     *     AND 一个停车小弟
     *
     * When 停车小弟去取车
     *
     * Then 返回那辆车
     */
    @Test
    public void shouldReturnCorrectCarWhenPickUpCarGivenTwoFullParkingLot() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Valet valet = new Valet(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        valet.parkCar(car1);
        Receipt receipt = valet.parkCar(car2);

        Car actualCar = valet.pickUpCar(receipt);

        assertEquals(car2, actualCar);
    }

    /**
     * Given 一个停车小弟
     *     AND 一个容量为 1 的满停车场和一个容量为 1 的空满停车场
     *     AND 一个其他收据
     *
     * When 小弟取车
     *
     * Then 返回null
     */
    @Test
    public void shouldReturnNullWhenPickUpCarGivenAFullParkingLotAndAEmptyParkingLotAndAInvalidReceipt() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Valet valet = new Valet(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        valet.parkCar(car);

        Receipt invalidReceipt = new Receipt();
        Car actualCar = valet.pickUpCar(invalidReceipt);

        assertNull(actualCar);
    }
}
