package citybike;

public class Bike {

    enum State {
        CAN_BE_RENTED,
        CAN_NOT_BE_RENTED,
        IN_SERVICE,
        DISCARDED
    }
    private Integer bikeID;
    private String color;
    State aState;
    private static Integer counter = 1;

    public Bike(String color, State aState){
        this.bikeID = counter++;
        this.color = color;
        this.aState = aState;
    }

    public Integer getBikeID() {
        return this.bikeID;
    }
    public State getaState(){
        return this.aState;
    }
}
