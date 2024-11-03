package org.example.a7electronicdevices;

public class Tablet extends Device {
    private double batteryLife;
    private boolean hasStylus;

    public Tablet(String name, double price, double weight, double batteryLife, boolean hasStylus) {
        super(DeviceType.TABLET, name, price, weight);
        this.batteryLife = batteryLife;
        this.hasStylus = hasStylus;
    }

    // Getters and setters
    public double getBatteryLife() { return batteryLife; }
    public void setBatteryLife(double batteryLife) { this.batteryLife = batteryLife; }

    public boolean isHasStylus() { return hasStylus; }
    public void setHasStylus(boolean hasStylus) { this.hasStylus = hasStylus; }

    @Override
    public String toString() {
        return super.toString() + String.format(", Battery: %.1f hrs, Stylus: %s", batteryLife, hasStylus ? "Yes" : "No");
    }
}
