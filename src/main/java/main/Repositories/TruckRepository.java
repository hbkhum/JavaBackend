package main.Repositories;

import main.Interfaces.Entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TruckRepository extends JpaRepository<Truck, String> {
}

