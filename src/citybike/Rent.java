package citybike;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Rent{

    private Integer bikeID;
    private GregorianCalendar rentStart;
    private GregorianCalendar rentEnd;

    public Rent(Integer bikeId, GregorianCalendar rentStart){
        this.bikeID = bikeId;
        this.rentStart = rentStart;
    }
    public void setRentEnd(){
        this.rentEnd = (GregorianCalendar) Calendar.getInstance();
    }

    public Integer getBikeID() {
        return bikeID;
    }

    public GregorianCalendar getRentStart() {
        return rentStart;
    }

    public GregorianCalendar getRentEnd() {
        return rentEnd;
    }
}
