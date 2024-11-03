package org.example.a7electronicdevices;

public abstract class Device {
    private DeviceType type;
    private String name;
    private double price;
    private double weight;

    public Device(DeviceType type, String name, double price, double weight) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public DeviceType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getWeight() {
        return weight;
    }


    public void setType(DeviceType type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }



    @Override
    public String toString() {
        return "Type: " + type + ", Name: " + name + ", Price: $" + price + ", Weight: " + weight + "kg";
    }
}
