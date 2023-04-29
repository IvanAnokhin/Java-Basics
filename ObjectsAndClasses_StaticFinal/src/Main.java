public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor(2500,8,7,"Intel core");
        System.out.println("-------------------------");
        Ram ram = new Ram(8.2,RamType.DIMM, 8);
        Storage storage = new Storage(StorageType.HDD, 1, 2);
        Monitor monitor = new Monitor(27, 5, MonitorType.IPS);
        Keyboard keyboard = new Keyboard(2,KeyboardType.CLASSIC, true);
        Computer computer = new Computer("ASUS", "Computer",processor, ram, storage, monitor, keyboard);
        System.out.println(computer.toString());
        System.out.println(computer.totalWeight + ram.weight + processor.weight + keyboard.weight + monitor.weight + storage.weight + "kg.");
    }
}