package core;

public class Shed {

    private final double shed_length;
    private final double shed_width;

    public Shed(double shed_length, double shed_width) {
        this.shed_length = shed_length;
        this.shed_width = shed_width;
    }

    public double getShed_length() {
        return shed_length;
    }

    public double getShed_width() {
        return shed_width;
    }
}