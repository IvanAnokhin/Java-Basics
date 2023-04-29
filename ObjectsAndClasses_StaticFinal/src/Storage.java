public class Storage {
    public String getWeight;
    private final StorageType type;
    public double weight;
    private final int volume;
    private StorageType Type;

    public Storage(StorageType type, double weight, int volume) {
        this.type = type;
        this.weight = weight;
        this.volume = volume;
    }

    public StorageType getType() {
        return Type;
    }

    public double getWeight() {
        return weight;
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return "Drive: "+ StorageType.HDD + "\n"
                + "Volume: "
                + volume + "\n" + "Weight: "
                + weight + "kg.";
    }
}
