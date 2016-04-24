package pl.bzawadka.model;

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

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Price createPrice() {
            return new Price(price, currency);
        }
    }
}
