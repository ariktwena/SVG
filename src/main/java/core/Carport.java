package core;

public class Carport {

    private final double carport_length;
    private final double carport_width;
    private final String roof;
    private final boolean withShed;
    private final Shed shed;


    public Carport(double carport_length, double carport_width, String roof, boolean withShed, Shed shed) {
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.roof = roof;
        this.withShed = withShed;
        this.shed = shed;
    }

    public double getCarport_length() {
        return carport_length;
    }

    public double getCarport_width() {
        return carport_width;
    }

    public String getRoof() {
        return roof;
    }

    public boolean isWithShed() {
        return withShed;
    }

    public Shed getShed() {
        return shed;
    }
}