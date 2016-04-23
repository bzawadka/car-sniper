package pl.bzawadka.model;

public class Car extends BaseObject {
    private Make make;
    private String model;
    private int year;
    private int price;
    private Currency currency;
    private SaleType saleType;
    private Engine engine;

    public Car(Make make, String model, int year, int price, Currency currency, SaleType saleType, Engine engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.currency = currency;
        this.saleType = saleType;
        this.engine = engine;
    }

    public Make getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public SaleType getSaleType() {
        return saleType;
    }

    public Engine getEngine() {
        return engine;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Make make;
        private String model;
        private int year;
        private int price;
        private Currency currency;
        private SaleType saleType;
        private Engine engine;

        public Builder setMake(Make make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Builder setSaleType(SaleType saleType) {
            this.saleType = saleType;
            return this;
        }

        public Builder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Car createCar() {
            return new Car(make, model, year, price, currency, saleType, engine);
        }
    }
}