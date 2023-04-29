public class Keyboard {
    public final double weight;
    boolean backlight = true;
    private KeyboardType Type;

    public Keyboard(double weight, KeyboardType Type, boolean backlight) {
        this.weight = weight;
        this.backlight = backlight;
    }

    public double getWeight() {
        return weight;
    }

    public KeyboardType getType() {
        return Type;
    }

    public boolean getBacklight() {
        return backlight;
    }

    public String toString() {
        return "Weight: " + weight + "kg."
                + "\n" + "Type keyboard: " + KeyboardType.CLASSIC +
                "\n" + "The presence of backlight: " + true;
    }
}