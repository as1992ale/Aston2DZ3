package builder;

// Product class
public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private boolean hasBluetooth;
    private boolean hasWiFi;

    // Package-private constructor, can only be created through builder
    Computer(String CPU, String RAM, String storage, String graphicsCard,
             boolean hasBluetooth, boolean hasWiFi) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.hasBluetooth = hasBluetooth;
        this.hasWiFi = hasWiFi;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public boolean hasBluetooth() { return hasBluetooth; }
    public boolean hasWiFi() { return hasWiFi; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU +
                ", RAM=" + RAM +
                ", Storage=" + storage +
                ", GraphicsCard=" + graphicsCard +
                ", Bluetooth=" + hasBluetooth +
                ", WiFi=" + hasWiFi + "]";
    }
}