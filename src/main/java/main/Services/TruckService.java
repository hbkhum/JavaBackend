package main.Services;


import main.Interfaces.Entities.Truck;
import main.Repositories.DataRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TruckService {
    @Autowired
    private DataRepositories dataRepositories;

    public List<Truck> getAllTrucks(){
        return dataRepositories.truckRepository.findAll();
    }

    public Truck getTruck(String id){
        Truck truck= dataRepositories.truckRepository.getOne(id);
        if(Objects.isNull(truck)){
            /* handle this exception using {@link RestExceptionHandler} */
        }
        return new Truck().build(truck);
    }

    public String addTruck(Truck truck) {
        UUID uuid = UUID.randomUUID();

        Truck _truck= new Truck();
        _truck.setModel(truck.getModel());
        _truck.setMake(truck.getMake());
        _truck.setVin(truck.getVin());
        _truck.setYear(truck.getYear());
        _truck.setTruckId(uuid.toString());
        _truck.setColor(truck.getColor());

        dataRepositories.truckRepository.save(_truck);


        return _truck.getTruckId();
    }

    public Boolean updateTruck(Truck truck, String id) {
        Truck _truck = dataRepositories.truckRepository.getOne(id);
        if(Objects.isNull(_truck)){
            /* handle this exception using {@link RestExceptionHandler} */
            //throw new EntityNotFoundException(User.class, id);
        }
        _truck.setTruckId(truck.getTruckId());
        _truck.setModel(truck.getModel());
        _truck.setMake(truck.getMake());
        _truck.setVin(truck.getVin());
        _truck.setYear(truck.getYear());
        _truck.setColor(truck.getColor());
        dataRepositories.truckRepository.save(_truck);
        return true;
    }
    public Boolean deleteTruck(String id) {
        Truck _truck = dataRepositories.truckRepository.getOne(id);
        dataRepositories.truckRepository.delete(_truck);
        return true;
    }
}
