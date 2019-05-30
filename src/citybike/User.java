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
    public User(){}                                                                 //for checkWhichUser()

    public void rentABike(Integer bikeID){
        if(Main.bikes.get(bikeID).getaState() == Bike.State.CAN_BE_RENTED) {        //check if the bike can be rented
            Main.checkWhichStation(bikeID);                                         //removes the bike in the correct station
            this.currentlyRentedBike = bikeID;
            GregorianCalendar today = (GregorianCalendar) Calendar.getInstance();
            this.rent = new Rent(bikeID, today);                                    //creates Rent-Object for tracking
            this.rents.add(this.rent);                                              //adds actual Rent-Object to an
        }else{                                                                      //ArrayList, every time the rentABike() is called
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
        this.rent.setRentEnd();                                                     //adds the renting End in Rent-Object
        this.currentlyRentedBike = null;
    }
    public void printAllRentedBikesEver(){
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss dd.MM.yyyy");
        String printName = this.name + " " + this.surname;
        System.out.printf("%S" + "%17s" + "%28s%n", printName, "Start", "End");
        System.out.println("----------------------------------------------------------------------");
        for(Rent rent : rents) {
            System.out.printf("Bike" + "%2S" + "%34S" + "%30S%n", rent.getBikeID(), sdf.format(rent.getRentStart().getTime()),
                    sdf.format(rent.getRentEnd().getTime()));
        }
    }
}
