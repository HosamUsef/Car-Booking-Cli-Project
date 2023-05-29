package com.cliproject;


import com.cliproject.Booking.CarBooking;
import com.cliproject.Booking.CarBookingDAO;
import com.cliproject.Booking.CarBookingServices;
import com.cliproject.Car.Car;
import com.cliproject.Car.CarArrayDataAccessService;
import com.cliproject.Car.CarServices;
import com.cliproject.User.User;
import com.cliproject.User.UserArrayDataAccessService;
import com.cliproject.User.UserServices;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;
        UUID result2;
//        String result3;
        boolean keepLooping = true;
        CarArrayDataAccessService carArrayDataAccessService=new CarArrayDataAccessService();
        CarServices carServices = new CarServices(carArrayDataAccessService);
        UserArrayDataAccessService userArrayDataAccessService=new UserArrayDataAccessService();
        UserServices userServices=new UserServices(userArrayDataAccessService);
        CarBookingDAO carBookingDAO=new CarBookingDAO();
        CarBookingServices carBookingServices =new CarBookingServices(carBookingDAO,userServices);
        while (keepLooping) {
            System.out.println("1\uFE0F⃣ - Book Car\n" +
                    "2\uFE0F⃣ - View All User Booked Cars\n" +
                    "3\uFE0F⃣ - View All Bookings\n" +
                    "4\uFE0F⃣ - View Available Cars\n" +
                    "5\uFE0F⃣ - View Available Electric Cars\n" +
                    "6\uFE0F⃣ - View all users\n" +
                    "7\uFE0F⃣ - Exit");
            result=scanner.nextInt();

            switch (result) {
                case 1:
                    carServices.getAllCars();
                    System.out.println("➡\uFE0F select car reg number ");
                    String result3=scanner.next();
                    userServices.getAllUsers();
                    System.out.println("➡\uFE0F select user id ");
                    String uuidAsString = scanner.next();
                    UUID uuid = UUID.fromString(uuidAsString);
                    User user=userServices.getSingleUser(uuid);
                    Car car=carServices.getSingleCars(result3);
                    CarBooking carBooking=new CarBooking(user,car);
                    carBookingServices.saveNewBooking(carBooking);
                    break;
                case 2:
                    userServices.getAllUsers();
                    System.out.println("➡\uFE0F select user id ");
                    String uidAsString = scanner.next();
                    UUID uid = UUID.fromString(uidAsString);
                    carBookingServices.getAllUserBooked(uid);
                    System.out.println("\n");
                    break;
                case 3:
                    carBookingServices.getAllBookings();
                    System.out.println("\n");
                    break;
                case 4:
                    carServices.getAllCars();
                    System.out.println("\n");
                    break;
                case 5:
                    carServices.getElectricCars();
                    System.out.println("\n");
                    break;
                case 6:
                    userServices.getAllUsers();
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("Exiting");
                    keepLooping = false;
                    break;
                default:
                    System.out.println(result + " not a valid option\n");
            }
        }

    }

}
