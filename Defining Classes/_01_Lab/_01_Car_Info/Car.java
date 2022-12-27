package _06_Defining_Classes._01_Defining_Classes_Lab._01_Car_Info;

public class Car {
    private String brand;
    private String model;
    private int horse_power;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(int horse_power) {
        this.horse_power = horse_power;
    }

    public String carInfo(){
        return String.format("The car is: %s %s - %d HP.",this.brand, this.model, this.horse_power);
    }
}
