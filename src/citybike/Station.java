package citybike;

import java.util.ArrayList;

public class Station {

    private Integer stationID;
    private String location;
    private ArrayList<Integer> bikes;
    private static Integer counter = 1;

    public Station(String location){
        this.stationID = counter++;
        this.location = location;
        this.bikes = new ArrayList<>();
    }
    public Station(){}

    public Integer getStationID(){
        return this.stationID;
    }
    public void addBike(Integer bikeID){
        this.bikes.add(bikeID);
    }
    public void removeBike(Integer bikeID){
        this.bikes.remove(bikeID);
    }
    public ArrayList<Integer> getBikes(){
        return this.bikes;
    }
    public void returnBike(Integer bikeID){
        if(this.bikes.size() < 5) {
            addBike(bikeID);
            Main.checkWhichUser(bikeID);

        }else{
            System.out.println("Sorry this station is already full");
        }
    }
}
