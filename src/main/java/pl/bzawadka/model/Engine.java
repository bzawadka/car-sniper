package pl.bzawadka.model;

public class Engine {
    private Fuel fuel;
    private double size;
    private int power;

    private Engine(Fuel fuel, double size, int power) {
        this.fuel = fuel;
        this.size = size;
        this.power = power;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public double getSize() {
        return size;
    }

    public int getPower() {
        return power;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Fuel fuel;
        private double size;
        private int power;

        public Builder setFuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }

        public Builder setSize(double size) {
            this.size = size;
            return this;
        }

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Engine createEngine() {
            return new Engine(fuel, size, power);
        }
    }
}
