package pl.bzawadka.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Price.Builder.class)
public class Price extends BaseObject {
    private int price;
    private Currency currency;

    public Price(int price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int price;
        private Currency currency;

        public Builder withPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Price build() {
            return new Price(price, currency);
        }
    }
}
