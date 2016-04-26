package pl.bzawadka.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Currency.CHF;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Make.AUDI;
import static pl.bzawadka.model.SaleType.AUCTION;

public class CarTest {

    @Test
    public void testToString() {
        Car car = Car.builder()
                .setMake(AUDI)
                .setModel("A4")
                .setPrice(Price.builder()
                        .setPrice(10000)
                        .setCurrency(CHF)
                        .createPrice())
                .setYear(2008)
                .setSaleType(AUCTION)
                .setEngine(Engine.builder()
                        .setFuel(DIESEL)
                        .setSize(2.0)
                        .setPower(140)
                        .createEngine())
                .createCar();

        assertThat(car).matches(
                c -> c.toString().contains("make=AUDI,model=A4,year=2008"));
        assertThat(car).matches(
                c -> c.toString().contains("price=10000,currency=CHF"));
    }
}