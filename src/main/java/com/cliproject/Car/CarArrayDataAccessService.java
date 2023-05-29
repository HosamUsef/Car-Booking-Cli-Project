package com.cliproject.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarArrayDataAccessService implements CarDAO{
    private  static   List<Car> cars=new ArrayList<>();


    public static List<Car> getCars() {
        return cars;
    }

    public static void setCars(List<Car> cars) {
        CarArrayDataAccessService.cars = cars;
    }

    static {
        cars.add(new Car("1234", BigDecimal.valueOf(132, 0), Brand.BMW, false));
        cars.add(new Car("1233", BigDecimal.valueOf(89, 0), Brand.TESLA, true));
        cars.add(new Car("1323", BigDecimal.valueOf(50, 0), Brand.BMW, false));
        cars.add(new Car("4544", BigDecimal.valueOf(132, 0), Brand.MERCEDES, false));

    }

    public  List<Car> getAllCars(){
        return cars;
    }
    public  List<Car> getElectricCars(){
        List<Car> elctricCars=new ArrayList<>();
        for (Car car:cars
             ) {
            if(car.isElectric()){
                elctricCars.add(car);
            }
        }
        return elctricCars;
    }



}
