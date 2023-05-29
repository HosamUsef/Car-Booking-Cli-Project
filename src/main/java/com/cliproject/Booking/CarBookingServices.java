package com.cliproject.Booking;

import com.cliproject.Car.Car;
import com.cliproject.Car.CarArrayDataAccessService;
import com.cliproject.User.UserServices;

import java.util.*;

public class CarBookingServices {
    private final CarBookingDAO carBookingDAO;

    private final UserServices userServices;

    public CarBookingServices(CarBookingDAO carBookingDAO, UserServices userServices) {
        this.carBookingDAO = carBookingDAO;
        this.userServices = userServices;
    }


    public void saveNewBooking(CarBooking carBooking) {
        List<Car> cars = new ArrayList<>();
        cars = CarArrayDataAccessService.getCars();
        carBookingDAO.saveBooking(carBooking);
        System.out.println("Successfully booked car with reg number "
                + carBooking.getCar().getRegNumber() +
                " for user " + carBooking.getUser() + "\n" +
                "Booking ref: " + carBooking.getBookingId());
        cars.removeIf(o -> o.getRegNumber().equals(carBooking.getCar().getRegNumber()));
        CarArrayDataAccessService.setCars(cars);
    }

    public void getAllBookings() {
        List<CarBooking> carBookings = carBookingDAO.getAllBookings();
        if (carBookings.size() == 0) {
            System.out.println("No booking avaliable ☹\uFE0F\n");
        }
        carBookings.forEach(System.out::println);

    }

    public void getAllUserBooked(UUID id) {
        List<CarBooking> carBookings = carBookingDAO.getAllBookings();
        if (carBookings.isEmpty()) {
            System.out.println("❌ user " + userServices.getSingleUser(id) + " has no cars booked");
            return;
        }
        for (CarBooking carBooking : carBookings) {

                if (carBooking.getUser().getId().equals(id)) {
                    System.out.println(carBooking.getUser() + "\n");
                } else {
                    System.out.println("❌ user " + userServices.getSingleUser(id) + " has no cars booked");
                }


        }
    }
}
