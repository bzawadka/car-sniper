package pl.bzawadka.model;

import static java.util.Objects.requireNonNull;

public enum Fuel {
    PETROL,
    DIESEL;

    public static Fuel from(String src) {
        requireNonNull(src, "src must not be null");
        return Fuel.valueOf(src.toUpperCase());
    }
}
