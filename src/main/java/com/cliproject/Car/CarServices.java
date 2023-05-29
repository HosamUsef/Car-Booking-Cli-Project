package com.cliproject.Car;
import java.util.List;

public class CarServices {
    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarServices(CarArrayDataAccessService carArrayDataAccessService) {

        this.carArrayDataAccessService = carArrayDataAccessService;
    }


    public  void getAllCars(){
        List<Car>  cars=carArrayDataAccessService.getAllCars();
        cars.forEach(System.out::println);
        if (cars.isEmpty()){
            System.out.println("❌ No cars avaliable for renting");
        }
    }

    public  Car getSingleCars(String regnumber){
        List<Car> cars=carArrayDataAccessService.getAllCars();
        return cars.stream().filter(car -> car.getRegNumber().equals(regnumber))
                .findFirst().
                orElseThrow(()-> new IllegalArgumentException("Customer with  id [%s] not found")) ;

    }

    public  void getElectricCars(){
        List<Car> cars=carArrayDataAccessService.getElectricCars();
        if(cars.isEmpty()){
            System.out.println("❌ No cars avaliable for renting ");
        }
        cars.forEach(System.out::println);
    }

}
