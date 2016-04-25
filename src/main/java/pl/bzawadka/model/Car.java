package pl.bzawadka.model;

import java.net.URL;

public class Car extends BaseObject {
    private Make make;
    private String model;
    private int year;
    private Price price;
    private SaleType saleType;
    private Engine engine;
    private URL url;

    public Car(Make make, String model, int year, Price price, SaleType saleType, Engine engine, URL url) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.saleType = saleType;
        this.engine = engine;
        this.url = url;
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

    public Price getPrice() {
        return price;
    }

    public SaleType getSaleType() {
        return saleType;
    }

    public Engine getEngine() {
        return engine;
    }

    public URL getUrl() {
        return url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Make make;
        private String model;
        private int year;
        private Price price;
        private SaleType saleType;
        private Engine engine;
        private URL url;

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

        public Builder setPrice(Price price) {
            this.price = price;
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

        public Builder setUrl(URL url) {
            this.url = url;
            return this;
        }

        public Car createCar() {
            return new Car(make, model, year, price, saleType, engine, url);
        }
    }
}
