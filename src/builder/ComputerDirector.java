package builder;

// Director class for constructing predefined computer configurations
public class ComputerDirector {

    public Computer buildGamingComputer(ComputerBuilder builder) {
        return builder.setCPU("Intel i9-13900K")
                .setRAM("32GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setBluetooth(true)
                .setWiFi(true)
                .build();
    }

    public Computer buildOfficeComputer(ComputerBuilder builder) {
        return builder.setCPU("Intel i5-12400")
                .setRAM("16GB DDR4")
                .setStorage("512GB SSD")
                .setGraphicsCard("Integrated Graphics")
                .setBluetooth(true)
                .setWiFi(false)
                .build();
    }

    public Computer buildBudgetComputer(ComputerBuilder builder) {
        return builder.setCPU("AMD Ryzen 5 5600G")
                .setRAM("8GB DDR4")
                .setStorage("256GB SSD")
                .setGraphicsCard("Integrated Graphics")
                .setBluetooth(false)
                .setWiFi(true)
                .build();
    }
}