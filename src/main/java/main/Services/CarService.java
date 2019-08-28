package main.Services;

import main.Interfaces.Entities.Car;

import main.Repositories.DataRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CarService {
    @Autowired
    private DataRepositories dataRepositories;

    public List<Car> getAllCars(){
        return dataRepositories.carRepository.findAll();
    }

    public Car getCar(String id){
        Car car= dataRepositories.carRepository.getOne(id);
        if(Objects.isNull(car)){
            /* handle this exception using {@link RestExceptionHandler} */
        }
        return new Car().build(car);
    }

    public String addCar(Car car) {
        UUID uuid = UUID.randomUUID();

        Car _car= new Car();
        _car.setModel(car.getModel());
        _car.setMake(car.getMake());
        _car.setVin(car.getVin());
        _car.setYear(car.getYear());
        _car.setCarId(uuid.toString());
        _car.setColor(car.getColor());

        dataRepositories.carRepository.save(_car);


        return _car.getCarId();
    }

    public Boolean updateCar(Car car, String id) {
        Car _car = dataRepositories.carRepository.getOne(id);
        if(Objects.isNull(_car)){
            /* handle this exception using {@link RestExceptionHandler} */
            //throw new EntityNotFoundException(User.class, id);
        }
        _car.setCarId(car.getCarId());
        _car.setModel(car.getModel());
        _car.setMake(car.getMake());
        _car.setVin(car.getVin());
        _car.setYear(car.getYear());
        _car.setColor(car.getColor());
        dataRepositories.carRepository.save(_car);
        return true;
    }
    public Boolean deleteCar(String id) {
        Car _car = dataRepositories.carRepository.getOne(id);
        dataRepositories.carRepository.delete(_car);
        return true;
    }
}
