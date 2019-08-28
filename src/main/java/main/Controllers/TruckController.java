package main.Controllers;

import main.Interfaces.Entities.Truck;
import main.Services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Truck")
@EnableAsync
public class TruckController {
    @Autowired
    private DataServices dataServices;

    @GetMapping
    //@Async
    public List<Truck> findAll() {

        return dataServices.truckService.getAllTrucks();
    }
    @GetMapping("/{id}")
    public Truck getTruckById(@PathVariable("id") String id){
        return dataServices.truckService.getTruck(id);
    }

    @PostMapping
    public ResponseEntity<String> addTruck(@Valid @RequestBody Truck truck){

        //return ResponseEntity.ok("HEY");
        return ResponseEntity.ok(dataServices.truckService.addTruck(truck));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateTruck( @PathVariable("id") String id,@Valid @RequestBody Truck truck){
        //return  ResponseEntity.ok(true);
        return ResponseEntity.ok(dataServices.truckService.updateTruck(truck, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTruck(@PathVariable("id") String id){

        return ResponseEntity.ok(dataServices.truckService.deleteTruck(id));
    }
}
