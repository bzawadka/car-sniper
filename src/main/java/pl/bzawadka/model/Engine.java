package pl.bzawadka.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

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

    @JsonPOJOBuilder(buildMethodName = "createEngine", withPrefix = "set")
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
