package _06_Defining_Classes._02_Defining_Classes_Exersices._03_Speed_Racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPer1km;
    private int distance;

    public Car(String model, double fuelAmount, double fuelPer1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPer1km = fuelPer1km;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPer1km() {
        return fuelPer1km;
    }

    public void setFuelPer1km(double fuelPer1km) {
        this.fuelPer1km = fuelPer1km;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void drive(int distance){
        double fuelForDrive = this.fuelPer1km * distance;
        if (fuelForDrive <= this.fuelAmount){
            this.fuelAmount-=fuelForDrive;
            this.distance+=distance;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model, this.fuelAmount, this.distance);
    }
}
