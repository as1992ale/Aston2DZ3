package builder;

// Builder interface
public interface ComputerBuilder {
    ComputerBuilder setCPU(String CPU);
    ComputerBuilder setRAM(String RAM);
    ComputerBuilder setStorage(String storage);
    ComputerBuilder setGraphicsCard(String graphicsCard);
    ComputerBuilder setBluetooth(boolean hasBluetooth);
    ComputerBuilder setWiFi(boolean hasWiFi);
    Computer build();
}