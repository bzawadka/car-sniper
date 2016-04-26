package pl.bzawadka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bzawadka.CarRepository;
import pl.bzawadka.model.Car;
import pl.bzawadka.model.Make;

import java.net.MalformedURLException;
import java.util.List;

@RestController
public class CarController {
    private static Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(path = "/cars")
    public List<Car> getCars() throws MalformedURLException {
        Make make = Make.AUDI;
        LOGGER.info("Fetching cars: " + make);
        return carRepository.findByMake(make);
    }
}
