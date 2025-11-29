package builder;

// Concrete builder implementation
public class ConcreteComputerBuilder implements ComputerBuilder {
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private boolean hasBluetooth = false;
    private boolean hasWiFi = false;

    @Override
    public ComputerBuilder setCPU(String CPU) {
        this.CPU = CPU;
        return this;
    }

    @Override
    public ComputerBuilder setRAM(String RAM) {
        this.RAM = RAM;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public ComputerBuilder setBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
        return this;
    }

    @Override
    public ComputerBuilder setWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
        return this;
    }

    @Override
    public Computer build() {
        // Validation can be added here
        if (CPU == null || RAM == null || storage == null) {
            throw new IllegalStateException("CPU, RAM and Storage are required");
        }
        return new Computer(CPU, RAM, storage, graphicsCard, hasBluetooth, hasWiFi);
    }
}