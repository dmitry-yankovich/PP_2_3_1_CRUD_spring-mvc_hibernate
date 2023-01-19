package web.dao;

import web.models.Car;
import java.util.List;


public interface CarDao {

    List<Car> index();
    List<Car> carList(int number);
}
