package main.Repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataRepositories {
    @Autowired
    public CarRepository carRepository;
    @Autowired
    public TruckRepository truckRepository;
}
