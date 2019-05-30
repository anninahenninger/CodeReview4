package citybike;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    Station station;
    User user;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        station = new Station("Riesenrad");
        user = new User("Fritz", "Kurz");
        Main.users.put(2, user);
        user.setCurrentlyRentedBike(5);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void returnBike() {
        assertEquals(0, station.getBikes().size());
        assertEquals(5, user.getCurrentlyRentedBike());
        station.returnBike(5);
        assertEquals(5, station.getBikes().get(0));
        assertNull(user.getCurrentlyRentedBike());
        station.returnBike(4);
        assertEquals(4,station.getBikes().get(1));
        assertEquals(2, station.getBikes().size());
        station.returnBike(2);
        station.returnBike(3);
        station.returnBike(7);
        assertEquals(5, station.getBikes().size());
        station.returnBike(9);
        assertEquals(5, station.getBikes().size());
    }
}