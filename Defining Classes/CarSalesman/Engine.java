package DefiningClasses.CarSalesman;

public class Engine {
    //model, power, displacement, and efficiency
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    //{EngineModel}:
    //Power: {EnginePower}
    //Displacement: {EngineDisplacement}
    //Efficiency: {EngineEfficiency}
    public String toString() {
        return String.format("%s:%n" +
                "Power: %s%n" +
                "Displacement: %s%n" +
                "Efficiency: %s", model, power, displacement, efficiency);
    }
}
