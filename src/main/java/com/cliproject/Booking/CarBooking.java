package com.cliproject.Booking;

import com.cliproject.Car.Car;
import com.cliproject.User.User;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {
     private UUID bookingId;
    private User user;
    private Car car;
    private final LocalTime bookingTime;
    boolean isCanceld;


    public CarBooking( User user, Car car) {
        this.bookingId = UUID.randomUUID();
        this.user = user;
        this.car = car;
        bookingTime=LocalTime.now();
        isCanceld=false;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceld=" + isCanceld +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return isCanceld == that.isCanceld && Objects.equals(bookingId, that.bookingId) && Objects.equals(user, that.user) && Objects.equals(car, that.car) && Objects.equals(bookingTime, that.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, user, car, bookingTime, isCanceld);
    }

}
