package main.Interfaces.Entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Trucks", schema = "VehicleContext", catalog = "")
@Data
public class Truck extends Vehicle {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "TruckId")
    private String truckId;
    @Basic
    @Column(name = "Model")
    private String model;
    @Basic
    @Column(name = "Make")
    private String make;
    @Basic
    @Column(name = "VIN")
    private String vin;
    @Basic
    @Column(name = "Color")
    private  String color;
    @Basic
    @Column(name = "Year")
    private  int year;




    public Truck() {

    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String t) {
        truckId=t;
    }




    public Truck build(Truck truck){
        this.truckId = truck.getTruckId();
        this.model = truck.getModel();
        this.make = truck.getMake();
        this.vin = truck.getVin();
        this.year = truck.getYear();
        this.color=truck.getColor();
        return this;
    }
}
