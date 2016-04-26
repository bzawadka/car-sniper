package pl.bzawadka.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Engine.Builder.class)
public class Engine extends BaseObject {
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

        public Builder withFuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }

        public Builder withSize(double size) {
            this.size = size;
            return this;
        }

        public Builder withPower(int power) {
            this.power = power;
            return this;
        }

        public Engine build() {
            return new Engine(fuel, size, power);
        }
    }
}
