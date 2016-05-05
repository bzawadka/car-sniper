package pl.bzawadka;

import pl.bzawadka.model.Car;
import pl.bzawadka.model.Engine;
import pl.bzawadka.model.Price;

import java.net.MalformedURLException;
import java.net.URL;

import static pl.bzawadka.model.Currency.CHF;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Fuel.PETROL;
import static pl.bzawadka.model.Make.AUDI;
import static pl.bzawadka.model.Make.MAZDA;
import static pl.bzawadka.model.SaleType.AUCTION;

public class Garage {

    public static Car audiA4() {
        return audiA4builder().build();
    }

    public static Car audiA5() {
        return audiA4builder().withModel("A5").withPrice(chfPrice(34000)).withYear(2015).build();
    }

    public static Car mazda3() {
        return mazda3Builder().build();
    }

    public static Car mazda6() {
        return mazda3Builder().withModel("6").withPrice(chfPrice(23000)).withYear(2015).build();
    }

    private static Car.Builder mazda3Builder() {
        return Car.builder()
                .withMake(MAZDA)
                .withModel("3")
                .withYear(2014)
                .withPrice(chfPrice(15400))
                .withSaleType(AUCTION)
                .withEngine(Engine.builder()
                        .withFuel(PETROL)
                        .withSize(2.0)
                        .withPower(165)
                        .build())
                .withUrl(url());
    }

    private static Car.Builder audiA4builder() {
        return Car.builder()
                .withMake(AUDI)
                .withModel("A4")
                .withYear(2008)
                .withPrice(chfPrice(10000))
                .withSaleType(AUCTION)
                .withEngine(Engine.builder()
                        .withFuel(DIESEL)
                        .withSize(2.0)
                        .withPower(140)
                        .build())
                .withUrl(url());
    }

    private static Price chfPrice(int price) {
        return Price.builder()
                .withPrice(price)
                .withCurrency(CHF)
                .build();
    }

    private static URL url() {
        URL url = null;
        try {
            url = new URL("http://car-sniper.ch/1234");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
