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
        return Car.builder()
                .setMake(AUDI)
                .setModel("A4")
                .setYear(2008)
                .setPrice(Price.builder()
                        .setPrice(10000)
                        .setCurrency(CHF)
                        .createPrice())
                .setSaleType(AUCTION)
                .setEngine(Engine.builder()
                        .setFuel(DIESEL)
                        .setSize(2.0)
                        .setPower(140)
                        .createEngine())
                .setUrl(url())
                .createCar();
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
