package citybike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    Station station;
    User usi;
    User user;
    Bike bike;
    Bike noBike;

    @BeforeEach
    void setUp() {
        bike = new Bike("lilac", Bike.State.CAN_BE_RENTED);
        noBike = new Bike("black", Bike.State.DISCARDED);
        Main.bikes.put(4, bike);
        Main.bikes.put(8, noBike);
        station = new Station("Riesenrad");
        Main.stations.put(2, station);
        station.addBike(4);
        station.addBike(8);
        user = new User("Fritz", "Kurz");
        usi = new User("Tanja", "Vizvary");
        //Main.stations.put(2, station);
    }

    @Test
    void rentABike() {
        assertNull(user.getCurrentlyRentedBike());
        assertEquals(2,station.getBikes().size());
        user.rentABike(4);
        assertEquals(4, user.getCurrentlyRentedBike());
        assertEquals(1,station.getBikes().size());

        assertNull(usi.getCurrentlyRentedBike());
        assertEquals(1,station.getBikes().size());
        usi.rentABike(8);
        assertNull(usi.getCurrentlyRentedBike());
        assertEquals(1, station.getBikes().size());
    }
}