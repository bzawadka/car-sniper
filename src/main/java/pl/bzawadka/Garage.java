package pl.bzawadka;

import pl.bzawadka.model.Car;
import pl.bzawadka.model.Engine;
import pl.bzawadka.model.Price;

import java.net.MalformedURLException;
import java.net.URL;

import static pl.bzawadka.model.Currency.CHF;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Make.AUDI;
import static pl.bzawadka.model.SaleType.AUCTION;

public class Garage {

    public static Car audiA4() {
        return audiA4builder().build();
    }

    public static Car audiA5() {
        return audiA4builder().withModel("A5").withYear(2015).build();
    }

    private static Car.Builder audiA4builder() {
        return Car.builder()
                .withMake(AUDI)
                .withModel("A4")
                .withYear(2008)
                .withPrice(Price.builder()
                        .withPrice(10000)
                        .withCurrency(CHF)
                        .build())
                .withSaleType(AUCTION)
                .withEngine(Engine.builder()
                        .withFuel(DIESEL)
                        .withSize(2.0)
                        .withPower(140)
                        .build())
                .withUrl(url());
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
