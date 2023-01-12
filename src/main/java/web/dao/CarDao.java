package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;
import web.models.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDao {
    private static long CARS_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT, "Lada", "Vesta", Color.RED));
        cars.add(new Car(++CARS_COUNT, "Volkswagen", "Polo", Color.BLACK));
        cars.add(new Car(++CARS_COUNT, "Renault", "Sandero", Color.WHITE));
        cars.add(new Car(++CARS_COUNT, "Kia", "Rio", Color.BLUE));
        cars.add(new Car(++CARS_COUNT, "Nissan", "Note", Color.GREEN));
    }

    public List<Car> index() {
        return cars;
    }

    public List<Car> carList(int number) {

        number = (number == 0) ? cars.size() : number;
        return cars.stream().limit(number).collect(Collectors.toList());
    }
}
