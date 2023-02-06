package io.tutorial.garageApp.service;

import io.tutorial.garageApp.model.Car;
import io.tutorial.garageApp.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;
    ArrayList<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(1, "Lagouna", "Renault", 2014, Car.Color.RED),
            new Car(2, "5008", "Peageot", 2014, Car.Color.YELLOW),
            new Car(3, "C4", "Citroen", 2014, Car.Color.BLUE),
            new Car(4, "206", "Peageot", 2014, Car.Color.GREEN),
            new Car(5, "Lagouna", "Renault", 2014, Car.Color.BLUE)
    ));

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(long id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    public void deleteCar(long id) {
        cars.removeIf(car -> car.getId() == id);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void updateCar(Car car, long id) {
        cars.forEach(car1 -> {
            if (car1.getId() == id) {
                cars.set(cars.indexOf(car1), car);
            }
        });
    }
}
