public class Monitor {
    public final int diagonal;
    public String getWeight;
    public double weight;
    public final MonitorType Type;

    public Monitor(int diagonal, double weight, MonitorType type) {
        this.diagonal = diagonal;
        this.weight = weight;
        Type = type;
    }
    public int getDiagonal() {
        return diagonal;
    }
    public double getWeight() {
        return weight;
    }
    public MonitorType getType() {
        return Type;
    }
    public String toString() {
        return "Screen: " + Type + "\n" + "Screen Diagonal: " + diagonal + "\n" + "Weight Screen " + weight + "kg.";
    }
}

