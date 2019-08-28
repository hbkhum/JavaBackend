package main.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DataServices {
    @Autowired
    public CarService carService;
    @Autowired
    public TruckService truckService;
}


