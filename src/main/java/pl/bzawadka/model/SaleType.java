package pl.bzawadka.model;

import static java.util.Objects.requireNonNull;

public enum SaleType {
    AUCTION,
    FIXED_PRICE;

    public static SaleType from(String src) {
        requireNonNull(src, "src must not be null");
        return SaleType.valueOf(src.toUpperCase());
    }
}
