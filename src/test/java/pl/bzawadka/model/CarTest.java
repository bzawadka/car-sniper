package pl.bzawadka.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Currency.CHF;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Make.AUDI;
import static pl.bzawadka.model.Make.MAZDA;
import static pl.bzawadka.model.SaleType.AUCTION;

public class CarTest {

    @Test
    public void testToString() {
        Car car = Car.builder()
                .withMake(AUDI)
                .withModel("A4")
                .withPrice(Price.builder()
                        .withPrice(10000)
                        .withCurrency(CHF)
                        .build())
                .withYear(2008)
                .withSaleType(AUCTION)
                .withEngine(Engine.builder()
                        .withFuel(DIESEL)
                        .withSize(2.0)
                        .withPower(140)
                        .build())
                .build();

        assertThat(car).matches(
                c -> c.toString().contains("make=AUDI,model=A4,year=2008"));
        assertThat(car).matches(
                c -> c.toString().contains("price=10000,currency=CHF"));
    }

    @Test
    public void testDeserialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue("{\"id\":null,\"make\":\"MAZDA\",\"model\":\"6\",\"year\":2016," +
                "\"price\":{\"price\":10000,\"currency\":\"CHF\"},\"saleType\":\"AUCTION\"," +
                "\"engine\":{\"fuel\":\"DIESEL\",\"size\":2.0,\"power\":140}," +
                "\"url\":\"http://car-sniper.ch/1234\"}", Car.class);
        assertThat(car.getMake()).isEqualTo(MAZDA);
        assertThat(car.getModel()).isEqualTo("6");
        assertThat(car.getYear()).isEqualTo(2016);
    }

}