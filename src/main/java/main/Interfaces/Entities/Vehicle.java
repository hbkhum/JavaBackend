package main.Interfaces.Entities;


public abstract class  Vehicle implements  IVehicle {
    private String model;
    private String make;
    private String vin;
    private  String color;
    private  int year;


    public String getModel() {
        return model;
    }
    public String getMake() {
        return make;
    }
    public String getVin() {
        return vin;
    }
    public String getColor() {
        return color;
    }
    public int getYear() {
        return year;
    }

    public void setModel(String m) {
        model=m;
    }
    public void setMake(String m) {
        make=m;
    }
    public void setVin(String v) {
        vin=v;
    }
    public void setColor(String c) {
        color=c;
    }
    public void setYear(int y) {
        year=y;
    }


}
