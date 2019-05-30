package citybike;

import java.util.HashMap;
import java.util.Map;

public class Main {

    //HashMaps are outside of main, because that way they are accessible in the methods
    static HashMap<Integer, Station> stations = new HashMap<>();
    static HashMap<Integer, User> users = new HashMap<>();
    static HashMap<Integer, Bike> bikes = new HashMap<>();

    public static void main(String[] args) {

        //Creation of several bikes and put them into a HashMap
        Bike b1 = new Bike("white", Bike.State.CAN_BE_RENTED);
        Bike b2 = new Bike("blue", Bike.State.CAN_NOT_BE_RENTED);
        Bike b3 = new Bike("white", Bike.State.IN_SERVICE);
        Bike b4 = new Bike("red", Bike.State.DISCARDED);
        Bike b5 = new Bike("yellow", Bike.State.CAN_BE_RENTED);
        Bike b6 = new Bike("pink", Bike.State.CAN_BE_RENTED);
        Bike b7 = new Bike("green", Bike.State.CAN_NOT_BE_RENTED);
        Bike b8 = new Bike("gold", Bike.State.CAN_BE_RENTED);

        bikes.put(b1.getBikeID(),b1);
        bikes.put(b2.getBikeID(),b2);
        bikes.put(b3.getBikeID(),b3);
        bikes.put(b4.getBikeID(),b4);
        bikes.put(b5.getBikeID(),b5);
        bikes.put(b6.getBikeID(),b6);
        bikes.put(b7.getBikeID(),b7);
        bikes.put(b8.getBikeID(),b8);

        // Locations of Stations are created and added to HashMap
        Station st1 = new Station("Schönbrunn");
        Station st2 = new Station("Oper");
        Station st3 = new Station("Secession");

        stations.put(st1.getStationID(), st1);
        stations.put(st2.getStationID(), st2);
        stations.put(st3.getStationID(), st3);

        // Bikes are added to Location
        st1.addBike(1);
        st1.addBike(3);
        st1.addBike(6);
        st2.addBike(2);
        st2.addBike(5);
        st2.addBike(8);
        st2.addBike(7);
        st3.addBike(4);

        // Creation of users and adding to HashMap
        User u1 = new User("Brad", "Pitt");
        User u2 = new User("Kevin", "Spacey");
        User u3 = new User("Demi", "Moore");
        User u4 = new User("Taylor", "Swift");

        users.put(u1.getUserID(), u1);
        users.put(u2.getUserID(), u2);
        users.put(u3.getUserID(), u3);
        users.put(u4.getUserID(), u4);

        //Testing data
        System.out.println("User " + u1.getCurrentlyRentedBike());
        System.out.println("Station: " + st1.getBikes().toString());
        u1.rentABike(1);
        System.out.println("User " + u1.getCurrentlyRentedBike());
        System.out.println("Station: " + st1.getBikes().toString());

        st3.returnBike(1);
        System.out.println("User " + u1.getCurrentlyRentedBike());
        System.out.println("Station: " + st3.getBikes().toString());

        u1.rentABike(5);
        st2.returnBike(5);

        u1.printAllRentedBikesEver();

    }
    public static void checkWhichStation(Integer bikeID){
        Station station = new Station();
        for(Map.Entry<Integer, Station> entry : stations.entrySet()){   //go through stations-HashMap
            if(entry.getValue().getBikes().contains(bikeID)){           //looks for bikeID
                station = entry.getValue();                             //in which station bike was found
                break;
            }
        }
        station.removeBike(bikeID);
    }
    public static void checkWhichUser(Integer bikeID){
        User user = new User();
        for(Map.Entry<Integer, User> entry : users.entrySet()){         //go through users-HashMap
            if(entry.getValue().getCurrentlyRentedBike() == bikeID){    //gives back the user, with the sought-after bikeID
                user = entry.getValue();
                break;
            }
        }
        user.removeBike(bikeID);
    }
}
