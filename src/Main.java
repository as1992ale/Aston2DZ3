import strategy.*;
import chain.*;
import builder.*;
import proxy.*;
import decorator.*;
import adapter.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация паттернов проектирования ===\n");

        // 1. Стратегия
        System.out.println("1. Паттерн СТРАТЕГИЯ:");
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(100.0);

        cart.setPaymentStrategy(new PayPalPayment("john@example.com"));
        cart.checkout(50.0);
        System.out.println();

        // 2. Цепочка обязанностей
        System.out.println("2. Паттерн ЦЕПОЧКА ОБЯЗАННОСТЕЙ:");
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        errorLogger.logMessage(Logger.INFO, "This is an information.");
        errorLogger.logMessage(Logger.DEBUG, "This is a debug level information.");
        errorLogger.logMessage(Logger.ERROR, "This is an error information.");
        System.out.println();

        // 3. Строитель (обновленная версия)
        System.out.println("3. Паттерн СТРОИТЕЛЬ:");

        // Создание кастомного компьютера
        ComputerBuilder builder = new ConcreteComputerBuilder();
        Computer customPC = builder.setCPU("AMD Ryzen 7 5800X")
                .setRAM("16GB DDR4")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 3070")
                .setBluetooth(true)
                .setWiFi(true)
                .build();
        System.out.println("Кастомный ПК: " + customPC);

        // Использование директора для создания предопределенных конфигураций
        ComputerDirector director = new ComputerDirector();
        Computer gamingPC = director.buildGamingComputer(new ConcreteComputerBuilder());
        Computer officePC = director.buildOfficeComputer(new ConcreteComputerBuilder());
        Computer budgetPC = director.buildBudgetComputer(new ConcreteComputerBuilder());

        System.out.println("Игровой ПК: " + gamingPC);
        System.out.println("Офисный ПК: " + officePC);
        System.out.println("Бюджетный ПК: " + budgetPC);
        System.out.println();

        // 4. Прокси
        System.out.println("4. Паттерн ПРОКСИ:");
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image loaded only when displayed
        image1.display();
        image1.display(); // Already loaded
        image2.display();
        System.out.println();

        // 5. Декоратор
        System.out.println("5. Паттерн ДЕКОРАТОР:");
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " $" + simpleCoffee.getCost());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.getCost());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription() + " $" + sugarMilkCoffee.getCost());
        System.out.println();

        // 6. Адаптер
        System.out.println("6. Паттерн АДАПТЕР:");
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        ModernPrinter modernPrinter = new PrinterAdapter(legacyPrinter);
        modernPrinter.printDocument("Hello, Adapter Pattern!");
    }
}