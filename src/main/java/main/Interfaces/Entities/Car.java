package main.Interfaces.Entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "Cars", schema = "VehicleContext", catalog = "")
@Data
public class Car extends Vehicle {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "CarId")
    private String carId;
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

    public String getCarId() {
        return carId;
    }

    public void setCarId(String c) {
        carId=c;
    }



    public Car() {

    }

    public Car build(Car car){
        this.carId = car.getCarId();
        this.model = car.getModel();
        this.make = car.getMake();
        this.vin = car.getVin();
        this.year = car.getYear();
        this.color=car.getColor();
        return this;
    }
}
