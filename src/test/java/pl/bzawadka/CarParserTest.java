package pl.bzawadka;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import pl.bzawadka.model.*;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Make.AUDI;
import static pl.bzawadka.model.SaleType.FIXED_PRICE;

public class CarParserTest {

    private CarParser underTest;

    @Before
    public void setUp() {
        underTest = new CarParser();
    }

    @Test
    public void testParseCarFromComparisHtml() throws Exception {
        Document doc = readFile("audi-a6-2.7.html");
        Car expected = Car.builder()
                .setMake(AUDI)
                .setModel("A6")
                .setYear(2010)
                .setPrice(Price.builder()
                    .setPrice(12500)
                    .setCurrency(Currency.CHF)
                    .createPrice())
                .setSaleType(FIXED_PRICE)
                .setEngine(Engine.builder()
                        .setFuel(DIESEL)
                        .setSize(2.7)
/*
                        .setPower(190)
*/
                        .createEngine())
                .createCar();

        Car actual = underTest.parseCar(doc);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    private Document readFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String html = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        return Jsoup.parse(html);
    }
}