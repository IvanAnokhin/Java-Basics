public class Computer {
    private final Processor processor;
    private final Ram ram;
    private final Storage storage;
    private final Monitor monitor;
    private final Keyboard keyboard;
    private final String vendor;
    public final String name;
    public double totalWeight;

    public Computer(String vendor, String name, Processor processor, Ram ram, Storage storage, Monitor monitor, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.monitor = monitor;
        this.keyboard = keyboard;

    }
    public Processor getProcessor() {
        return processor;
    }
    public Ram getRam() {
        return ram;
    }
    public Storage getStorage() {
        return storage;
    }
    public Monitor getMonitor() {
        return monitor;
    }
    public Keyboard getKeyboard() {
        return keyboard;
    }
    public double getTotalWeight() {
        totalWeight = processor.getWeight() + ram.getWeight() + storage.getWeight() + keyboard.getWeight() + monitor.getWeight();
        return totalWeight;
    }
    public  String toString() {
        return "Computer Characteistics: " + "\n" + "Computer name: " + name + "\n" + "Manufacturer: " + vendor + "\n"
                + "Processor: " + processor.toString() + "\n" + "RAM: " + ram.toString() + "\n"
                + "Storage of information:" + storage.toString() + "\n" + "Screen: " + monitor.toString() + "\n"
                + "Keyboard: " + keyboard.toString() + "\n" + "Total weight: ";
    }
}