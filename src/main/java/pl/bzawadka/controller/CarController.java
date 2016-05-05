package pl.bzawadka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bzawadka.CarRepository;
import pl.bzawadka.model.Car;

import java.net.MalformedURLException;

@RestController
public class CarController {
    private static Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(path = "/cars")
    public Iterable<Car> getCars() throws MalformedURLException {
        LOGGER.info("Fetching cars");
        return carRepository.findAll();
    }
}
