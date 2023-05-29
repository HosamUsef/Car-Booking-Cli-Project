package com.cliproject.Booking;
import java.util.ArrayList;
import java.util.List;

public class CarBookingDAO {
    private static List<CarBooking> carBookings;




    static {

        carBookings = new ArrayList<>();
    }


    public void saveBooking(CarBooking carBooking) {

        carBookings.add(carBooking);



    }
    public List<CarBooking> getAllBookings(){
        return carBookings;
    }

}
