package DefiningClasses.CarSalesman;

public class Car {
    //"{Model} {Engine} {Weight} {Color}
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getModel() {
        return model;
    }

    @Override
    //{CarModel}:
    //{EngineModel}:
    //Power: {EnginePower}
    //Displacement: {EngineDisplacement}
    //Efficiency: {EngineEfficiency}
    //Weight: {CarWeight}
    //Color: {CarColor}
    public String toString() {
        return String.format("%s:%n" +
                "%s%n" +
                "Weight: %s%n" +
                "Color: %s", model, engine, weight, color);
    }
}
