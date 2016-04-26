package pl.bzawadka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bzawadka.model.Car;
import pl.bzawadka.model.Engine;
import pl.bzawadka.model.Price;

import java.net.MalformedURLException;
import java.net.URL;

import static pl.bzawadka.model.Currency.CHF;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Make.AUDI;
import static pl.bzawadka.model.SaleType.AUCTION;

@RestController
public class CarController {

    @RequestMapping(path = "/car")
    public Car getCar() throws MalformedURLException {
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
                .setUrl(new URL("http://car-sniper.ch/1234"))
                .createCar();
    }
}
