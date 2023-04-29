public class Processor {
    private final int  frequency;
    private final int numberOfCores;
    public double weight;
    private final String manufacturer;

    public Processor(int frequency, int numberOfCores, int weight, String manufacturer) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }
    public int getFrequency() {
        return frequency;
    }
    public int getNumberOfCores() {
        return numberOfCores;
    }
    public double getWeight() {
        return weight;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String toString() {
        return "Frequency: " + frequency + "\n" +
                "Number of cores: " + numberOfCores + "\n" +
                "Manufacturer: " + manufacturer + "\n" +
                "Weight: " + weight + "kg.";
    }
}
