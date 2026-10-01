package tp_cloud_sc;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    private final List<Car> cars = new ArrayList<>();

    public CarController() {
        cars.add(new Car("AA11BB", "Ferrari", 100));
        cars.add(new Car("CC22DD", "BMW", 80));
        cars.add(new Car("EE33FF", "Mercedes", 90));
    }

    @GetMapping("/")
    public String hello() {
        return "Car Rental REST API";
    }

    @GetMapping("/cars")
    public List<Car> listOfCars() {
        return cars.stream()
                .filter(car -> !car.isRented())
                .toList();
    }

    @GetMapping("/cars/{plateNumber}")
    public Car aCar(@PathVariable String plateNumber) throws Exception {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst()
                .orElseThrow(() -> new Exception("Car not found"));
    }
}