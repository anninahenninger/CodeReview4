package citybike;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class User {

    private Integer userID;
    private String name;
    private String surname;
    private Integer currentlyRentedBike;
    private static Integer counter = 1;
    private Rent rent;
    private ArrayList<Rent> rents = new ArrayList<>();

    public User(String name, String surname){
        this.userID = counter++;
        this.name = name;
        this.surname = surname;
    }
    public User(){}

    public void rentABike(Integer bikeID){
        if(Main.bikes.get(bikeID).getaState() == Bike.State.CAN_BE_RENTED) {
            Main.checkWhichStation(bikeID);
            this.currentlyRentedBike = bikeID;
            GregorianCalendar today = (GregorianCalendar) Calendar.getInstance();
            this.rent = new Rent(bikeID, today);
            this.rents.add(this.rent);
        }else{
            System.out.println("This bike can't be rented at the moment!");
        }
    }
    public Integer getCurrentlyRentedBike(){
        return this.currentlyRentedBike;
    }
    public void setCurrentlyRentedBike(Integer bikeID){
        this.currentlyRentedBike = bikeID;
    }

    public Integer getUserID(){
        return this.userID;
    }
    public void removeBike(Integer bikeID){
        this.rent.setRentEnd();
        this.currentlyRentedBike = null;
    }
    public void printAllRentedBikesEver(){
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss dd.MM.yyyy");
        System.out.printf("%17S" + "%28S%n", "Start", "End");
        System.out.println("-------------------------------------------------------------");
        for(Rent rent : rents) {
            System.out.printf("Bike" + "%2S" + "%25S" + "%30S%n", rent.getBikeID(), sdf.format(rent.getRentStart().getTime()),
                    sdf.format(rent.getRentEnd().getTime()));
        }
    }
}
