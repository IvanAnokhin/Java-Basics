public class Ram {
    public double weight;
    private RamType type;
    private final int volume;
    private RamType Type;

    public Ram(double weight, RamType Type, int volume) {
        this.weight = weight;
        this.type = type;
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public RamType getType() {
        return Type;
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return ("Weight: " + weight + "kg." + "\n" + "Volume: " + volume + "\n" + "Type: " + RamType.DIMM);
    }
}
